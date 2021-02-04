package com.gishere.aicamera.config.mqtt.pub.service.payload;

import lombok.Data;

/**
 * 删除底库所有图片
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
@Data
public class PhotoLibImgDeleteAllPayloadDetail implements ServicePayloadDetail {
    private String libid;
}
