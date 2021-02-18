package com.gishere.aicamera.config.http.domain.push;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

/**
 * 推送数据
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Data
@JsonAutoDetect(getterVisibility=JsonAutoDetect.Visibility.NONE)
public class PushData {
    /**
     * 智能数据
     */
    private SmartData SmartData;
    /**
     * IPC 设备基本信息
     */
    private Properties Properties;

}
