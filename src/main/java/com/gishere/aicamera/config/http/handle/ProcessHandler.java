package com.gishere.aicamera.config.http.handle;

import com.gishere.aicamera.config.http.domain.push.PushData;

/**
 * @author niXueChao
 * @date 2021/2/4.
 */
public abstract class ProcessHandler<T> {
    protected ProcessHandler<?> nextHandler;


    public abstract void process(T data);

    public void next(PushData pushData) {
        T data = getData(pushData);
        if (data != null) {
            process(data);
        }
        if (nextHandler != null) {
            nextHandler.next(pushData);
        }
    }

    public abstract T getData(PushData pushData);

    public void setNextHandler(ProcessHandler<?> nextHandler) {
        this.nextHandler = nextHandler;
    }
}
