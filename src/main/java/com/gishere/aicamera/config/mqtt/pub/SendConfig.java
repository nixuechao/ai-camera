package com.gishere.aicamera.config.mqtt.pub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.support.MqttHeaders;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author niXueChao
 * @date 2021/2/4.
 */
@Slf4j
@Configuration
public class SendConfig {

    @Bean
    public ThreadPoolExecutor pubAfterSendProcessThreadPool() {
        return new ThreadPoolExecutor(1, 15, 2L, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5000),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("mqttPubAfterSendProcessThread");
                    return thread;
                });
    }

    @Bean
    public MessageSender messageSender(ThreadPoolExecutor pubAfterSendProcessThreadPool, DirectChannel pubChannel) {
        MessageSender sender = new MessageSender();
        sender.setPubChannel(pubChannel);
        sender.setBeforeSendHandler(null);
        sender.setPubAfterSendProcessThreadPool(pubAfterSendProcessThreadPool);
        sender.setAfterSendHandler((sent, message) -> {
            if (sent) {
                log.info("发送消息成功,{} {}", message.getHeaders().get(MqttHeaders.TOPIC), message.getPayload());
                return;
            }
            log.error("发送消息失败,{} {}", message.getHeaders().get(MqttHeaders.TOPIC), message.getPayload());
        });
        return sender;
    }
}
