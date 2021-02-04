package com.gishere.aicamera.config.mqtt.pub.service.payload;

import lombok.Data;

import java.util.List;

/**
 * 添加图片
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
@Data
public class PhotoLibImgAddPayloadDetail implements ServicePayloadDetail {

    private String libid;
    private UserInfoBean user_info;

    @Data
    public static class UserInfoBean {
        private String uid;
        private String name;
        private String img_url;
        private List<String> base64;
        private List<String> extra;
    }
}
