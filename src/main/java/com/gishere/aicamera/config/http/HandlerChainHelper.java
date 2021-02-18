package com.gishere.aicamera.config.http;

import com.gishere.aicamera.config.http.handle.ProcessHandler;
import com.gishere.aicamera.config.http.handle.PushDataHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niXueChao
 * @date 2021/2/4.
 */
public class HandlerChainHelper {

    private PushDataHandler handler;

    private final List<ProcessHandler<?>> handlerList = new ArrayList<>();


    private HandlerChainHelper() {
    }

    public static HandlerChainHelper createHandler(PushDataHandler handler) {
        HandlerChainHelper helper = new HandlerChainHelper();
        helper.handler = handler;
        return helper;
    }

    public HandlerChainHelper add(ProcessHandler<?> handler) {
        handlerList.add(handler);
        return this;
    }

    public PushDataHandler get() {
        ProcessHandler<?> tempHandler = handler;
        for (ProcessHandler<?> processHandler : handlerList) {
            tempHandler.setNextHandler(processHandler);
            tempHandler = processHandler;
        }
        return handler;
    }
}
