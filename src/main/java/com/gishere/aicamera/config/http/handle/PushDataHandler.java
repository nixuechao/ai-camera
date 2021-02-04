package com.gishere.aicamera.config.http.handle;

import com.gishere.aicamera.config.http.domain.push.PushData;
import lombok.extern.slf4j.Slf4j;

/**
 * IPC数据推送处理
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Slf4j
public class PushDataHandler extends ProcessHandler {

    @Override
    public void process(PushData pushData) {
        if (pushData == null) {
            return;
        }

        log.info("收到IPC数据推送,{}", pushData);
        if (nextHandler == null) {
            return;
        }
        nextHandler.process(pushData);
    }
}
