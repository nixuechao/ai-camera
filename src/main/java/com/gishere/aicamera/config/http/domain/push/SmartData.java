package com.gishere.aicamera.config.http.domain.push;

import lombok.Data;
import com.gishere.aicamera.config.http.domain.push.smart.*;

/**
 * @author niXueChao
 * @date 2021/2/4.
 */
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
    private FlowStats flowStats;
    /**
     * 数据识别
     */
    private Feature Feature;
}
