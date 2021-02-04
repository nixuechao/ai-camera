package com.gishere.aicamera.config.mqtt.pub.service.payload;

import lombok.Data;

/**
 * 删除底库
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
@Data
public class PhotoLibDeletePayloadDetail implements ServicePayloadDetail {
    private String libid;
}
