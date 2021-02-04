package com.gishere.aicamera.config.http.handle;

import com.gishere.aicamera.config.http.domain.push.PushData;
import lombok.extern.slf4j.Slf4j;

/**
 * 客流统计数据处理
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Slf4j
public class FlowStatsDataHandler extends ProcessHandler {

    @Override
    public void process(PushData pushData) {
        if (pushData.getSmartData().getFlowStats() == null) {
            return;
        }
        log.info("客流统计数据处理..");


        if (nextHandler == null) {
            return;
        }
        nextHandler.process(pushData);
    }
}
