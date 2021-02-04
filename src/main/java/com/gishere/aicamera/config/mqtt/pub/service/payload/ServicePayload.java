package com.gishere.aicamera.config.mqtt.pub.service.payload;

import com.gishere.aicamera.config.mqtt.pub.service.ServiceFunctionEnum;

/**
 * 服务相关payload
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
public class ServicePayload {
    /**
     * 请求id
     */
    private String request_id;
    /**
     * 服务code
     *
     * @see ServiceFunctionEnum
     */
    private String service_id;
    /**
     * 详细参数
     */
    private ServicePayloadDetail payload;

    public ServicePayload() {
    }

    public ServicePayload(String request_id, String service_id, ServicePayloadDetail payload) {
        this.request_id = request_id;
        this.service_id = service_id;
        this.payload = payload;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public ServicePayloadDetail getPayload() {
        return payload;
    }

    public void setPayload(ServicePayloadDetail payload) {
        this.payload = payload;
    }
}
