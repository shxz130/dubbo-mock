package com.github.dumock.core.handler;

import com.github.dumock.core.bean.parent.ActionRequest;
import com.github.dumock.core.bean.parent.ActionResponse;
import com.github.jettyrun.common.utils.type.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jetty on 18/6/29.
 */
public abstract class ActionHandler<T extends ActionRequest,F extends ActionResponse> implements Handler<T,F> {

    @Override
    public void handle(final T t,final F f) {
        Map<String,Object> map=new HashMap<String,Object>();
        check(t, f, map);
        before(t, f, map);
        doHandle(t, f, map);
        after(t, f, map);
    }

    protected abstract void before(final T t,final F f, final Map map);

    protected abstract void after(final T t,final F f, final Map map);

    protected abstract void check(final T t,final F f, final Map map);

    protected abstract void doHandle(final T t,final F f, final Map map);
}
