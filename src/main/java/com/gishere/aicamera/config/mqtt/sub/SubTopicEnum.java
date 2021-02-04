package com.gishere.aicamera.config.mqtt.sub;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 订阅主题
 *
 * @author niXueChao
 * @date 2021/2/2.
 */
public enum SubTopicEnum {
    /**
     * 属性周期上报
     */
    SUB_PROPERTY_REPORT("hobot/+/property/report"),
    /**
     * 属性变更应答异步
     */
    SUB_PROPERTY_ASYNC("hobot/+/property/asyncupd/response"),

    /**
     * 属性变更应答同步
     */
    SUB_PROPERTY_SYNC("hobot/+/property/syncupd/+/response"),

    /**
     * 服务应答异步
     */
    SUB_SERVER_ASYNC("hobot/+/service/async/response"),

    /**
     * 服务应答同步
     */
    SUB_SERVER_SYNC("hobot/+/service/sync/+/response"),
    ;

    private String topic;

    SubTopicEnum(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    private String regex() {
        String regex = this.topic.replaceAll("\\+", "[\\\\w-\\\\s]+");
        return "^" + regex + "$";
    }

    public static SubTopicEnum match(String topic) {
        for (SubTopicEnum value : SubTopicEnum.values()) {
            if (topic.matches(value.regex())) {
                return value;
            }
        }
        return null;
    }

    public static String getClientId(String topic) {
        String str = "hobot/[\\w-\\s]+";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(topic);
        if (m.find()) {
            return m.group().substring(6);
        }
        return null;
    }

    public static String getRequestId(String topic) {
        String str = "[\\w-\\s]+/response";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(topic);
        if (m.find()) {
            return m.group().substring(6);
        }
        return null;
    }
}
