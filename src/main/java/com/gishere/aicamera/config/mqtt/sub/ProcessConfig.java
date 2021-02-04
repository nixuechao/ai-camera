package com.gishere.aicamera.config.mqtt.sub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author niXueChao
 * @date 2021/2/3.
 */
@Configuration
public class ProcessConfig {

    @Bean
    public ThreadPoolExecutor subProcessAsyncThreadPool() {
        return new ThreadPoolExecutor(1, 15, 2L, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5000),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("mqttSubMessageProcessThread");
                    return thread;
                });
    }
}
