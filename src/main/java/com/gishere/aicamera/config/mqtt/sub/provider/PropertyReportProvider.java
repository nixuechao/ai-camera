package com.gishere.aicamera.config.mqtt.sub.provider;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.gishere.aicamera.config.mqtt.sub.SubMessageProcessProvider;
import com.gishere.aicamera.config.mqtt.sub.SubTopicEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 属性上报
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
@Component
@Slf4j
public class PropertyReportProvider implements SubMessageProcessProvider {
    @Override
    public <T> void process(String clientId, String requestId, Message<T> message) {
        log.info("属性上报,client:{}", clientId);
        T payload = message.getPayload();
        JSONObject payloadJson = JSONUtil.parseObj(String.valueOf(payload));
        System.out.println(payloadJson);
    }

    @Override
    public SubTopicEnum supportTopic() {
        return SubTopicEnum.SUB_PROPERTY_REPORT;
    }

    @Override
    public boolean repeatAble() {
        return true;
    }

    @Override
    public boolean asynchronous() {
        return true;
    }

    @Override
    public String providerName() {
        return this.getClass().getName();
    }
}
