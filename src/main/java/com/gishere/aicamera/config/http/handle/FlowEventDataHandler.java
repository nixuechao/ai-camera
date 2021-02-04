package com.gishere.aicamera.config.http.handle;

import com.gishere.aicamera.config.http.domain.push.PushData;
import lombok.extern.slf4j.Slf4j;

/**
 * 过线时间数据处理
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Slf4j
public class FlowEventDataHandler extends ProcessHandler {
    @Override
    public void process(PushData pushData) {
        if (pushData.getSmartData().getFlowEvent() == null) {
            return;
        }
        log.info("过线事件数据处理..");


        if (nextHandler == null) {
            return;
        }
        nextHandler.process(pushData);
    }
}
