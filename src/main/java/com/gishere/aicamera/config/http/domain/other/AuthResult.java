package com.gishere.aicamera.config.http.domain.other;

import lombok.Data;
import lombok.Getter;

/**
 * @author niXueChao
 * @date 2021/2/2.
 */
@Getter
public class AuthResult {
    private String thing_id;
    private Connection connection;

    public AuthResult() {
    }

    public AuthResult(String thingId, String mqttBroker, String username, String password) {
        this.thing_id = thingId;
        Connection connection = new Connection();
        connection.setUsername(username);
        connection.setPassword(password);
        connection.setMqtt_broker(mqttBroker);
        connection.setUpstream_broker(mqttBroker);
        this.connection = connection;
    }

    @Data
    private static class Connection{
        private String mqtt_broker;
        private String username;
        private String password;
        private String x509_certification;
        private String upstream_broker;
        private String upstream_topic;
    }

}
