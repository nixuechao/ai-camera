package com.gishere.aicamera.config.mqtt;

import com.gishere.aicamera.config.mqtt.sub.SubMessageProcessorManager;
import com.gishere.aicamera.config.mqtt.sub.SubTopicEnum;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author niXueChao
 * @date 2021/2/2.
 */
@Slf4j
@Configuration
public class MqttConfig {

    /**
     * MQTT连接工厂
     *
     * @param property 连接属性
     * @return
     * @see ConnectionProperty
     */
    @Bean
    public MqttPahoClientFactory factory(ConnectionProperty property) {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(property.getCleanSession());
        options.setKeepAliveInterval(property.getKeepAliveInterval());
        options.setConnectionTimeout(property.getConnectionTimeout());
        options.setUserName(property.getUsername());
        options.setPassword(property.getPassword().toCharArray());
        options.setServerURIs(new String[]{property.getUri()});
        factory.setConnectionOptions(options);
        return factory;
    }

    /**
     * 订阅管道
     *
     * @return
     */
    @Bean
    public DirectChannel subChannel() {
        return new DirectChannel();
    }

    /**
     * 订阅适配器
     *
     * @param factory
     * @param clientProperty
     * @param subChannel
     * @return
     */
    @Bean
    public MqttPahoMessageDrivenChannelAdapter subAdapter(MqttPahoClientFactory factory, ClientProperty clientProperty, DirectChannel subChannel) {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(clientProperty.getSubClientId(), factory);

        List<String> topics = Arrays.stream(SubTopicEnum.values()).map(SubTopicEnum::getTopic).collect(Collectors.toList());
        for (String topic : topics) {
            adapter.addTopic(topic, 1);
        }
        adapter.setOutputChannel(subChannel);

        log.info("{} 订阅{}", clientProperty.getSubClientId(), topics.toString());
        return adapter;
    }

    /**
     * 定义订阅流程
     *
     * @param adapter
     * @param manager
     * @return
     */
    @Bean
    public IntegrationFlow subFlow(MqttPahoMessageDrivenChannelAdapter adapter, SubMessageProcessorManager manager) {
        return IntegrationFlows.from(adapter)
                .handle(manager::process)
                .get();
    }


    /**
     * 发布管道
     *
     * @return
     */
    @Bean
    public DirectChannel pubChannel() {
        return new DirectChannel();
    }

    /**
     * 发布消息处理器
     *
     * @param factory
     * @param clientProperty
     * @return
     */
    @Bean
    public MqttPahoMessageHandler pubHandler(MqttPahoClientFactory factory, ClientProperty clientProperty) {
        return new MqttPahoMessageHandler(clientProperty.getPubClientId(), factory);
    }

    /**
     * 定义发布流程
     *
     * @param pubChannel
     * @param handler
     * @return
     */
    @Bean
    public IntegrationFlow pubFlow(DirectChannel pubChannel, MqttPahoMessageHandler handler) {
        return IntegrationFlows.from(pubChannel).handle(handler).get();
    }


}
