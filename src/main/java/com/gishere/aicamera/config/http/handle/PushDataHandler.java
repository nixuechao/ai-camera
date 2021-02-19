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
public class PushDataHandler extends ProcessHandler<PushData> {
    @Override
    public void process(PushData data) {
        log.info("收到IPC数据推送,设备号:{}", data.getProperties().getDeviceId());
    }

    @Override
    public PushData getData(PushData pushData) {
        return pushData;
    }
}
