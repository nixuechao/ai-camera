package com.gishere.aicamera.config.http.handle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niXueChao
 * @date 2021/2/4.
 */
public class HandlerChainHelper {

    private ProcessHandler handler;

    private List<ProcessHandler> handlerList = new ArrayList<>();


    private HandlerChainHelper() {
    }

    public static HandlerChainHelper createHandler(ProcessHandler handler) {
        HandlerChainHelper helper = new HandlerChainHelper();
        helper.handler = handler;
        return helper;
    }

    public HandlerChainHelper add(ProcessHandler handler) {
        handlerList.add(handler);
        return this;
    }

    public ProcessHandler get() {
        ProcessHandler tempHandler = handler;
        for (ProcessHandler processHandler : handlerList) {
            tempHandler.setNextHandler(processHandler);
            tempHandler = processHandler;
        }
        return handler;
    }
}
