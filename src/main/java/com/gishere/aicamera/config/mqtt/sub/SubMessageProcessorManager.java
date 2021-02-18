package com.gishere.aicamera.config.mqtt.sub;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author niXueChao
 * @date 2021/2/3.
 */
@Component
@Slf4j
public class SubMessageProcessorManager {
    private final Set<SubMessageProcessProvider> providers;
    private final StringRedisTemplate redisTemplate;
    private final ThreadPoolExecutor subProcessAsyncThreadPool;

    private static final String PAYLOAD_REQUEST_ID_KEY_NAME = "request_id";
    private static final String SUB_REPEAT_MESSAGE_REDIS_KEY = "MQTT:REPEAT:";
    private static final long REPEAT_DURATION_MINUTES = 5;

    public SubMessageProcessorManager(Set<SubMessageProcessProvider> providers, StringRedisTemplate redisTemplate, ThreadPoolExecutor subProcessAsyncThreadPool) {
        this.providers = providers;
        this.redisTemplate = redisTemplate;
        this.subProcessAsyncThreadPool = subProcessAsyncThreadPool;
    }

    public <T> void process(Message<T> message) {
        Object topicObj = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC);
        if (topicObj == null) {
            log.error("无法获取消息topic:{}", message.getPayload());
            return;
        }
        String topic = topicObj.toString();

        SubTopicEnum matchTopicEnum = SubTopicEnum.match(topic);
        if (matchTopicEnum == null) {
            log.error("非法topic:{}", topic);
            return;
        }

        String clientId = SubTopicEnum.getClientId(topic);
        String requestId = SubTopicEnum.getRequestId(topic);

        if (requestId == null) {
            //只有同步应答topic才会有requestId,异步的requestId需要在payload中获取
            requestId = payloadRequestId(message.getPayload());
        }
        for (SubMessageProcessProvider provider : providers) {
            if (!matchTopicEnum.equals(provider.supportTopic())) {
                continue;
            }

            if (!provider.repeatAble()) {
                T payload = message.getPayload();
                String payloadStr = String.valueOf(payload);
                //考虑到哈希碰撞,在加上MD5一起作摘要
                String digests = payloadStr.hashCode() + DigestUtils.md5DigestAsHex(payloadStr.getBytes());
                String redisKey = SUB_REPEAT_MESSAGE_REDIS_KEY + provider.providerName() + ":" + clientId + ":" + digests;
                String repeat = redisTemplate.opsForValue().get(redisKey);
                if (StringUtils.hasText(repeat)) {
                    continue;
                }
                redisTemplate.opsForValue().set(redisKey, "", REPEAT_DURATION_MINUTES, TimeUnit.MINUTES);
            }
            if (provider.asynchronous()) {
                String finalRequestId = requestId;
                subProcessAsyncThreadPool.submit(() -> provider.process(clientId, finalRequestId, message));
                continue;
            }
            provider.process(clientId, requestId, message);
        }
    }

    /**
     * 从payload中获取requestId
     *
     * @param payload
     * @param <T>
     * @return
     */
    private <T> String payloadRequestId(T payload) {
        try {
            return JSONUtil.parseObj(payload).getStr(PAYLOAD_REQUEST_ID_KEY_NAME);
        } catch (Exception e) {
            return null;
        }
    }

}
