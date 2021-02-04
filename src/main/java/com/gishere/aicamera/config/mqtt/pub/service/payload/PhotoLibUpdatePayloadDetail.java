package com.gishere.aicamera.config.mqtt.pub.service.payload;

import lombok.Data;

/**
 * 全量更新底库
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
@Data
public class PhotoLibUpdatePayloadDetail implements ServicePayloadDetail {
    private String libid;
    private String name;
    private int threshold;
}
