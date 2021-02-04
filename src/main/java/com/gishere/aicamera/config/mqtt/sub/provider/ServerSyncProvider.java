package com.gishere.aicamera.config.mqtt.sub.provider;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.gishere.aicamera.config.mqtt.sub.SubMessageProcessProvider;
import com.gishere.aicamera.config.mqtt.sub.SubTopicEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 服务同步应答
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
@Component
@Slf4j
public class ServerSyncProvider implements SubMessageProcessProvider {

    @Override
    public <T> void process(String clientId, String requestId, Message<T> message) {
        log.info(" 服务同步应答,client{},request{}", clientId, requestId);
        JSONObject payloadJson = JSONUtil.parseObj(String.valueOf(message.getPayload()));
        System.out.println(payloadJson);
    }

    @Override
    public SubTopicEnum supportTopic() {
        return SubTopicEnum.SUB_SERVER_ASYNC;
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
