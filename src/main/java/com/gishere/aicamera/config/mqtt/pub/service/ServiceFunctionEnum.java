package com.gishere.aicamera.config.mqtt.pub.service;

/**
 * Mqtt服务请求(目前只有底库操作相关)
 *
 * @author niXueChao
 * @date 2021/2/3.
 */
public enum ServiceFunctionEnum {

    /**
     * 创建底库
     */
    photo_lib_create("8801"),
    /**
     * 删除底库
     */
    photo_lib_delete("8802"),
    /**
     * 全量更新底库
     */
    photo_lib_update("8813"),
    /**
     * 添加图片
     */
    photo_lib_img_add("8804"),
    /**
     * 删除图片
     */
    photo_lib_img_delete("8805"),
    /**
     * 删除底库所有图片
     */
    photo_lib_img_delete_all("8806"),
    /**
     * 查询用户信息
     */
    photo_lib_user_info("8810"),
    /**
     * 查询所有底库信息
     */
    photo_lib_info("8812"),
    /**
     * 批量添图
     */
    photo_lib_img_add_batch("9904"),
    ;

    private String serviceCode;

    ServiceFunctionEnum(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }
}
