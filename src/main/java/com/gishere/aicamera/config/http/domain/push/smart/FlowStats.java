package com.gishere.aicamera.config.http.domain.push.smart;

import lombok.Data;

/**
 * 客流统计数据
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Data
public class FlowStats {
    /**
     * 开始统计时间
     */
    private Integer Timestamp;

    /**
     * 统计时长
     */
    private Integer Interval;

    /**
     * 进线人次
     */
    private Integer InNumber;

    /**
     * 出线人次
     */
    private Integer OutNumber;

    /**
     * 线 ID
     */
    private Integer LineId;

    /**
     * 线类型, 0 表示进出线；1 表示途径线
     */
    private Integer LineType;

    /**
     * 总人数，过线（进出线/途径线）人次之和
     */
    private Integer TotalNumber;

    /**
     * 正脸抓拍人数
     */
    private Integer FrontNumber;

    /**
     * 进线总女性人数
     */
    private Integer InFemaleNumber;

    /**
     * 进线总男性人数
     */
    private Integer InMaleNumber;

    /**
     * 进线 0-6 岁总男性人数
     */
    private Integer InMale06Number;

    /**
     * 进线 7-12 岁总男性人数
     */
    private Integer InMale712Number;

    /**
     * 进线 13-18 岁总男性人数
     */
    private Integer InMale1318Number;

    /**
     * 进线 19-28 岁总男性人数
     */
    private Integer InMale1928Number;

    /**
     * 进线 29-35 岁总男性人数
     */
    private Integer InMale2935Number;

    /**
     * 进线 36-45 岁总男性人数
     */
    private Integer InMale3645Number;

    /**
     * 进线 46-55 岁总男性人数
     */
    private Integer InMale4655Number;

    /**
     * 进线大于等于 56 岁总男性人数
     */
    private Integer InMaleGt56Number;

    /**
     * 进线 0-6 岁总女性人数
     */
    private Integer InFemale06Number;

    /**
     * 进线 7-12 岁总女性人数
     */
    private Integer InFemale712Number;

    /**
     * 进线 13-18 岁总女性人数
     */
    private Integer InFemale1318Number;

    /**
     * 进线 19-28 岁总女性人数
     */
    private Integer InFemale1928Number;

    /**
     * 进线 29-35 岁总女性人数
     */
    private Integer InFemale2935Number;

    /**
     * 进线 36-45 岁总女性人数
     */
    private Integer InFemale3645Number;

    /**
     * 进线 46-55 岁总女性人数
     */
    private Integer InFemale4655Number;

    /**
     * 进线大于等于 56 岁总女性人数
     */
    private Integer InFemaleGt56Number;

    /**
     * 出线总女性人数
     */
    private Integer OutFemaleNumber;

    /**
     * 出线总男性人数
     */
    private Integer OutMaleNumber;

    /**
     * 出线 0-6 岁总男性人数
     */
    private Integer OutMale06Number;

    /**
     * 出线 7-12 岁总男性人数
     */
    private Integer OutMale712Number;

    /**
     * 出线 13-18 岁总男性人数
     */
    private Integer OutMale1318Number;

    /**
     * 出线 19-28 岁总男性人数
     */
    private Integer OutMale1928Number;

    /**
     * 出线 29-35 岁总男性人数
     */
    private Integer OutMale2935Number;

    /**
     * 出线 36-45 岁总男性人数
     */
    private Integer OutMale3645Number;

    /**
     * 出线 46-55 岁总男性人数
     */
    private Integer OutMale4655Number;


    /**
     * 出线大于等于 56 岁总男性人数
     */
    private Integer OutMaleGt56Number;

    /**
     * 出线 0-6 岁总女性人数
     */
    private Integer OutFemale06Number;

    /**
     * 出线 7-12 岁总女性人数
     */
    private Integer OutFemale712Number;

    /**
     * 出线 13-18 岁总女性人数
     */
    private Integer OutFemale1318Number;

    /**
     * 出线 19-28 岁总女性人数
     */
    private Integer OutFemale1928Number;

    /**
     * 出线 29-35 岁总女性人数
     */
    private Integer OutFemale2935Number;

    /**
     * 出线 36-45 岁总女性人数
     */
    private Integer OutFemale3645Number;

    /**
     * 出线 46-55 岁总女性人数
     */
    private Integer OutFemale4655Number;

    /**
     * 出线大于等于 56 岁总女性人数
     */
    private Integer OutFemaleGt56Number;

}
