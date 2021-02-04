package com.gishere.aicamera.config.mqtt.pub.service.payload;

import lombok.Data;

/**
 * 删除图片
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
@Data
public class PhotoLibImgDeletePayloadDetail implements ServicePayloadDetail {
    private String libid;
    private String uid;
}
