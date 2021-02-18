package com.gishere.aicamera.config.mqtt.pub;

/**
 * 发布主题
 *
 * @author niXueChao
 * @date 2021/2/2.
 */
public enum PubTopicEnum {
    /**
     * 属性变更请求异步
     */
    PUB_PROPERTY_ASYNC("hobot/+/property/asyncupd/request"),
    /**
     * 属性变更请求同步
     */
    PUB_PROPERTY_SYNC("hobot/+/property/syncupd/request"),

    /**
     * 服务下发异步
     */
    PUB_SERVER_ASYNC("hobot/+/service/async/request"),

    /**
     * 服务下发同步
     */
    PUB_SERVER_SYNC("hobot/+/service/sync/request"),
    ;


    private String topic;

    PubTopicEnum(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public String fillClientId(String clientId) {
        return topic.replace("+", clientId);
    }

}
