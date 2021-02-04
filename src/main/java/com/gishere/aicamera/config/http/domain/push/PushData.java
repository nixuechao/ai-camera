package com.gishere.aicamera.config.http.domain.push;

import lombok.Data;

/**
 * 推送数据
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Data
public class PushData {
    /**
     * 智能数据
     */
    private SmartData smartData;
    /**
     * IPC 设备基本信息
     */
    private Properties properties;

}
