package com.gishere.aicamera.config.http.handle;

import com.gishere.aicamera.config.http.domain.push.PushData;
import com.gishere.aicamera.config.http.domain.push.smart.FlowEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * 过线时间数据处理
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Slf4j
public class FlowEventDataHandler extends ProcessHandler<FlowEvent> {
    @Override
    public void process(FlowEvent data) {
        log.info("过线事件数据处理:{}", data);
    }

    @Override
    public FlowEvent getData(PushData pushData) {
        return pushData.getSmartData().getFlowEvent();
    }
}
