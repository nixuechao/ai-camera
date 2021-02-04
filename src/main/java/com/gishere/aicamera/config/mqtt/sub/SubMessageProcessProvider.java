package com.gishere.aicamera.config.mqtt.sub;

import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;

/**
 * @author niXueChao
 * @date 2021/2/3.
 */
public interface SubMessageProcessProvider {

    /**
     * 接收到订阅消息后的处理
     *
     * @param clientId  mqtt clientId也是IPC的设备号
     * @param requestId 请求id,有可能为空
     * @param message
     * @param <T>
     */
    <T> void process(String clientId, @Nullable String requestId, Message<T> message);

    /**
     * 返回支持的Topic
     *
     * @return
     */
    SubTopicEnum supportTopic();

    /**
     * 是否可以处理重复消息
     * mqtt qos=1 时可能会产生重复消息
     *
     * @return
     */
    boolean repeatAble();

    /**
     * 是否需要异步处理
     *
     * @return
     */
    boolean asynchronous();

    /**
     * providerName
     *
     * @return
     */
    String providerName();
}
