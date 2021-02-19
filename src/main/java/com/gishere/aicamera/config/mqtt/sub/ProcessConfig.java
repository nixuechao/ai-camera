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

    /**
     * 接收消息后若处理对象需要异步处理将使用此线程池
     *
     * @return
     * @see SubMessageProcessProvider#asynchronous()
     */
    @Bean("subProcessAsyncThreadPool")
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
