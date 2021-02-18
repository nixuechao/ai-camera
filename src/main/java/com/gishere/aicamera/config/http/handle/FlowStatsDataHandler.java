package com.gishere.aicamera.config.http.handle;

import com.gishere.aicamera.config.http.domain.push.PushData;
import com.gishere.aicamera.config.http.domain.push.smart.FlowStats;
import lombok.extern.slf4j.Slf4j;

/**
 * 客流统计数据处理
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Slf4j
public class FlowStatsDataHandler extends ProcessHandler<FlowStats> {
    @Override
    public void process(FlowStats data) {
        log.info("客流统计数据处理:{}", data);
    }

    @Override
    public FlowStats getData(PushData pushData) {
        return pushData.getSmartData().getFlowStats();
    }
}
