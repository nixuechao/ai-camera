package com.gishere.aicamera.config.mqtt.sub.provider;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.gishere.aicamera.config.mqtt.sub.SubMessageProcessProvider;
import com.gishere.aicamera.config.mqtt.sub.SubTopicEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 服务同步应答
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
@Component
@Slf4j
public class ServerSyncProvider implements SubMessageProcessProvider {
    private final StringRedisTemplate redisTemplate;

    public ServerSyncProvider(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public static final String IPC_SERVER_RESPONSE = "IPC:MQTT:SERVER:RESPONSE";

    @Override
    public <T> void process(String clientId, String requestId, Message<T> message) {
        log.info("服务同步应答,client:{},requestId:{}", clientId, requestId);
        JSONObject payloadJson = JSONUtil.parseObj(String.valueOf(message.getPayload()));

        //服务同步应答数据放到redis中两分钟
        redisTemplate.opsForValue().set(IPC_SERVER_RESPONSE + ":" + requestId, payloadJson.toString(), 2, TimeUnit.MINUTES);
        System.out.println(payloadJson);
    }

    @Override
    public SubTopicEnum supportTopic() {
        return SubTopicEnum.SUB_SERVER_SYNC;
    }

    @Override
    public boolean repeatAble() {
        return false;
    }

    @Override
    public boolean asynchronous() {
        return false;
    }

    @Override
    public String providerName() {
        return this.getClass().getName();
    }
}
