package com.gishere.aicamera.config.mqtt.pub.service.payload;

import lombok.Data;

/**
 * 查询所有底库信息
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
@Data
public class PhotoLibInfoPayloadDetail implements ServicePayloadDetail {
    private String libid;
    private String uid;
}
