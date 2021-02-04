package com.gishere.aicamera.config.http.domain.push.smart;

import cn.hutool.json.JSONArray;
import lombok.Data;

/**
 * 抓拍
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Data
public class Face {
    /**
     * 抓拍数据时间戳
     */
    private Integer TimeStamp;
    /**
     * 抓拍人脸 Id
     */
    private Integer PersonId;
    /**
     * 抓拍图片数据Base64
     */
    private String SnapShot;
    /**
     * 图片类型
     */
    private Integer ImgType;
    /**
     * 抓拍框的坐标
     */
    private JSONArray PicBox;
    /**
     * 人脸框中的坐标
     */
    private JSONArray FaceBox;
    /**
     * 性别，数值型 1 男性 0 女性
     */
    private Integer Gender;
    /**
     * 年龄区间，1: [0-18], 2: [19-35], 3: [36-55], 4
     * 56+
     */
    private Integer Age;

    /**
     * 活体打分：0 ~ 100
     */
    private Integer LivingScore;
    /**
     * 三轴角度归一化值：-2000 ~ 2000
     */
    private Integer Pose;
    /**
     * 绕 Y 轴旋转偏角：-90 ~ 90
     */
    private Integer Yaw;
    /**
     * 绕 X 轴旋转偏角：-90 ~ 90
     */
    private Integer Pitch;
    /**
     * 绕 Z 轴旋转偏角：-90 ~ 90
     */
    private Integer Roll;
    /**
     * 图片质量：-200 ~ 200
     */
    private Integer Quality;
}
