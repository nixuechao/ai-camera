package com.gishere.aicamera.config.http.handle;

import com.gishere.aicamera.config.http.domain.push.PushData;

/**
 * @author niXueChao
 * @date 2021/2/4.
 */
public abstract class ProcessHandler {
    protected ProcessHandler nextHandler;

    /**
     * 处理推送数据
     *
     * @param pushData
     */
    public abstract void process(PushData pushData);

    public void setNextHandler(ProcessHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
