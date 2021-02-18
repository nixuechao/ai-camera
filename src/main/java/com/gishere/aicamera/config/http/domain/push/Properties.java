package com.gishere.aicamera.config.http.domain.push;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

/**
 * IPC 设备基本信息
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@JsonAutoDetect(getterVisibility=JsonAutoDetect.Visibility.NONE)
@Data
public class Properties {
    /**
     * 可用作 IPC 安装地所属 SiteId，由管理工具配置
     */
    private String LevelOneId;

    /**
     * 可用作 IPC 安装地所属 Site 名称，由管理工具配
     * 置
     */
    private String LevelOneName;

    /**
     * 可用作 IPC 安装所属部门，由管理工具配置
     */
    private String LevelTwoId;

    /**
     * 可用作 IPC 设备 ID，由管理工具配
     */
    private String LevelTwoName;

    /**
     * IPC 设备 ID，由管理工具配置
     */
    private String DeviceId;

    /**
     * IPC 设备名称，由管理工具配置
     */
    private String DeviceName;

    /**
     * 本条数据发送的时间戳
     */
    private String TransmitTime;

    /**
     * IPC 的 Mac 地址
     */
    private String MacAddress;

    /**
     * IPC 的 IPV4 地址
     */
    private String IPv4Address;

    /**
     * IPC 的时区信息
     */
    private String TimeZone;

    /**
     * IPC 的时区名字
     */
    private String TimezoneName;

    /**
     * IPC 的基础版本信息
     */
    private String BaseVer;

    /**
     * IPC 的 OTA 版本
     */
    private String OTAVer;

    /**
     * IPC 的模型版本
     */
    private String ModelVer;

    /**
     * IPC 的固件版本
     */
    private String FirmwareVer;
    /**
     * IPC 的 SDK 版本
     */
    private String SDKVer;
    /**
     * IPC 的智能版本
     */
    private String SmartVer;
    /**
     * IPC 的序列号
     */
    private String SerialNumber;
}
