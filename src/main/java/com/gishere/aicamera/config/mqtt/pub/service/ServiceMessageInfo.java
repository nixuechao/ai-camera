package com.gishere.aicamera.config.mqtt.pub.service;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.gishere.aicamera.config.mqtt.pub.PubMessageInfo;
import com.gishere.aicamera.config.mqtt.pub.PubTopicEnum;
import com.gishere.aicamera.config.mqtt.pub.service.payload.ServicePayload;
import com.gishere.aicamera.config.mqtt.pub.service.payload.ServicePayloadDetail;

/**
 * @author niXueChao
 * @date 2021/2/4.
 */
public class ServiceMessageInfo implements PubMessageInfo {
    private PubTopicEnum topicEnum;
    private ServiceFunctionEnum functionEnum;
    private String clientId;
    private String requestId;
    private ServicePayloadDetail payloadDetail;

    private ServiceMessageInfo(Builder builder) {
        topicEnum = builder.topicEnum;
        functionEnum = builder.functionEnum;
        clientId = builder.clientId;
        requestId = builder.requestId;
        payloadDetail = builder.payloadDetail;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    @Override
    public PubTopicEnum getTopic() {
        return topicEnum;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public JSONObject getPayload() {
        ServicePayload servicePayload = new ServicePayload(requestId, functionEnum.getServiceCode(), payloadDetail);
        return JSONUtil.parseObj(servicePayload);
    }


    public static final class Builder {
        private PubTopicEnum topicEnum;
        private ServiceFunctionEnum functionEnum;
        private String clientId;
        private String requestId;
        private ServicePayloadDetail payloadDetail;

        private Builder() {
        }

        public Builder topicEnum(PubTopicEnum val) {
            topicEnum = val;
            return this;
        }

        public Builder functionEnum(ServiceFunctionEnum val) {
            functionEnum = val;
            return this;
        }

        public Builder clientId(String val) {
            clientId = val;
            return this;
        }

        public Builder requestId(String val) {
            requestId = val;
            return this;
        }

        public Builder payloadDetail(ServicePayloadDetail val) {
            payloadDetail = val;
            return this;
        }

        public ServiceMessageInfo build() {
            return new ServiceMessageInfo(this);
        }
    }
}
