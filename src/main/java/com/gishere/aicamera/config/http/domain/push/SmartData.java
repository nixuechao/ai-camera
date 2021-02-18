package com.gishere.aicamera.config.http.domain.push;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import com.gishere.aicamera.config.http.domain.push.smart.*;

/**
 * @author niXueChao
 * @date 2021/2/4.
 */
@JsonAutoDetect(getterVisibility=JsonAutoDetect.Visibility.NONE)
@Data
public class SmartData {
    /**
     * 抓拍
     */
    private Face Face;
    /**
     * 过线
     */
    private FlowEvent FlowEvent;
    /**
     * 客流统计
     */
    private FlowStats FlowStats;
    /**
     * 数据识别
     */
    private Feature Feature;
}
