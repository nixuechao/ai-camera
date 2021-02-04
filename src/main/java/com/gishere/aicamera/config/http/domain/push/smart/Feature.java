package com.gishere.aicamera.config.http.domain.push.smart;

import lombok.Data;

/**
 * 识别数据
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Data
public class Feature {

    /**
     * 抓拍时间戳
     */
    private Integer Timestamp;
    /**
     * 被识别的人的 Id，与抓拍图的 PersonId 对应
     */
    private Integer trackId;
    /**
     * 人脸特征值 128 位
     */
    private Byte FeatureInfo;
    /**
     * 被识别的底库照片，Base64 编码
     */
    private String MatchedImg;
    /**
     * 人脸特征库存中匹配的 ID，与增改 ID 接口中传入的参数 uid 一致
     */
    private String MatchedId;
    /**
     * 人脸特征匹配相似度
     */
    private Integer MatchedRate;
    /**
     * 人脸特征数据库 ID
     */
    private Integer DatabaseId;
    /**
     * 被识别的抓拍照片，Base64 编码
     */
    private String CropImg;
    /**
     * 人脸对应 Name 字段
     */
    private String Name;
    /**
     * 人脸对应 Ext1 字段
     */
    private String Ext1;
    /**
     * 人脸对应 Ext2 字段
     */
    private String Ext2;
    /**
     * 人脸对应 Ext3 字段
     */
    private String Ext3;
    /**
     * 人脸对应 Ext4 字段
     */
    private String Ext4;
    /**
     * 人脸对应 Ext5 字段
     */
    private String Ext5;

}
