package com.gishere.aicamera.config.http.handle;

import com.gishere.aicamera.config.http.domain.push.PushData;
import com.gishere.aicamera.config.http.domain.push.smart.Feature;
import lombok.extern.slf4j.Slf4j;

/**
 * 识别数据处理
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Slf4j
public class FeatureDataHandler extends ProcessHandler<Feature> {
    @Override
    public void process(Feature data) {
        log.info("识别数据处理:{}", data);
    }

    @Override
    public Feature getData(PushData pushData) {
        return pushData.getSmartData().getFeature();
    }

}
