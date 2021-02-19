package com.gishere.aicamera.config.http;

import com.gishere.aicamera.config.http.handle.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author niXueChao
 * @date 2021/2/4.
 */
@Configuration
public class HandlerConfig {

    /**
     * 定义处理链
     *
     * @return
     */
    @Bean
    public ProcessHandler camPushDataProcessHandler() {
        return HandlerChainHelper.createHandler(new PushDataHandler())
                .add(new FaceDataHandler())
                .add(new FeatureDataHandler())
                .add(new FlowEventDataHandler())
                .add(new FlowStatsDataHandler())
                .get();
    }


}
