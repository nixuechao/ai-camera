package com.gishere.aicamera.config.mqtt.pub;

import cn.hutool.json.JSONObject;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.Assert;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author niXueChao
 * @date 2021/2/3.
 */
@Setter
@Slf4j
public class MessageSender {
    private DirectChannel pubChannel;
    private ThreadPoolExecutor pubAfterSendProcessThreadPool;
    private BeforeSendHandler beforeSendHandler;
    private AfterSendHandler afterSendHandler;


    public void send(PubMessageInfo messageInfo) {
        //BeforeSend
        if (beforeSendHandler != null) {
            if (!beforeSendHandler.handle(messageInfo)) {
                log.warn("取消发送消息{}: {}: {}", messageInfo.getTopic(), messageInfo.getClientId(), messageInfo.getPayload());
            }
        }

        //校验
        JSONObject payload = messageInfo.getPayload();
        PubTopicEnum topic = messageInfo.getTopic();
        String clientId = messageInfo.getClientId();
        Assert.notNull(payload, "空的payload");
        Assert.notNull(topic, "空的topic");
        Assert.notNull(clientId, "空的clientId");

        //组装Message
        String mqttTopic = topic.fillClientId(clientId);
        Message<String> message = MessageBuilder.withPayload(payload.toString())
                .setHeader(MqttHeaders.TOPIC, mqttTopic)
                .setHeader(MqttHeaders.QOS, 1)
                .build();

        boolean sent = pubChannel.send(message);

        //afterSend
        pubAfterSendProcessThreadPool.submit(() -> afterSendHandler.handle(sent, message));
    }

    @FunctionalInterface
    public interface BeforeSendHandler {
        /**
         * 消息发送前的处理
         *
         * @param messageInfo
         * @return true:继续发送,false终止发送
         */
        boolean handle(PubMessageInfo messageInfo);
    }

    @FunctionalInterface
    public interface AfterSendHandler {
        /**
         * 消息发送后的处理,将会被异步执行
         *
         * @param sent    是否发送成功
         * @param message
         */
        void handle(boolean sent, Message<String> message);
    }
}