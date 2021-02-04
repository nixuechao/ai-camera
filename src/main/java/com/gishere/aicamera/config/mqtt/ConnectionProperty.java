package com.gishere.aicamera.config.mqtt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author niXueChao
 * @date 2021/2/2.
 */
@Component
@ConfigurationProperties(prefix = "mqtt.connection")
@Data
public class ConnectionProperty {
    private String uri;
    private String username;
    private String password;
    private Boolean cleanSession;
    private Integer keepAliveInterval;
    private Integer connectionTimeout;
}
