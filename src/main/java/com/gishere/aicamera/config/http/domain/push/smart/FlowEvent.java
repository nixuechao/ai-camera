package com.gishere.aicamera.config.http.domain.push.smart;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

/**
 * 过线事件
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@JsonAutoDetect(getterVisibility=JsonAutoDetect.Visibility.NONE)
@Data
public class FlowEvent {
    /**
     * 过线时间戳
     */
    private Integer Timestamp;
    /**
     * 过线人员ID
     */
    private Integer PersonId;
    /**
     * 过线事件类型，0 表示进线，1 表示出线
     */
    private Integer FlowType;

}
