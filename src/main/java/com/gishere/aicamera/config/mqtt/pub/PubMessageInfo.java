package com.gishere.aicamera.config.mqtt.pub;

import cn.hutool.json.JSONObject;

/**
 * @author niXueChao
 * @date 2021/2/4.
 */
public interface PubMessageInfo {

    /**
     * 获取主题
     *
     * @return
     */
    PubTopicEnum getTopic();

    /**
     * 获取IPC客户端id(这通常是IPC的设备序列号)
     *
     * @return
     */
    String getClientId();

    /**
     * 获取Mqtt消息荷载
     *
     * @return
     */
    JSONObject getPayload();

}
