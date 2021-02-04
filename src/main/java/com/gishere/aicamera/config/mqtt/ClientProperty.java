package com.gishere.aicamera.config.mqtt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author niXueChao
 * @date 2021/2/2.
 */
@Component
@ConfigurationProperties(prefix = "mqtt.client")
@Data
public class ClientProperty {
    private String pubClientId;
    private String subClientId;
}
