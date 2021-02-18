package com.gishere.aicamera.config.http.handle;

import com.gishere.aicamera.config.http.domain.push.PushData;
import com.gishere.aicamera.config.http.domain.push.smart.Face;
import lombok.extern.slf4j.Slf4j;

/**
 * 抓拍数据处理
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Slf4j
public class FaceDataHandler extends ProcessHandler<Face> {
    @Override
    public void process(Face data) {
        log.info("处理抓拍数据:{}", data);
    }

    @Override
    public Face getData(PushData pushData) {
        return pushData.getSmartData().getFace();
    }
}
