package com.github.dumock.core.handler;

import com.github.dumock.core.bean.parent.ActionRequest;
import com.github.dumock.core.bean.parent.ActionResponse;

import java.util.Map;

/**
 * Created by jetty on 18/6/29.
 */
public interface Handler<T extends ActionRequest,F extends ActionResponse> {

    public void handle(final T t,final F f);

}
