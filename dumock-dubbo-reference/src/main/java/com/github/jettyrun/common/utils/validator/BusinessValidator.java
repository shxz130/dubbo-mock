package com.github.jettyrun.common.utils.validator;

/**
 * Created by jetty on 18/2/13.
 */
public interface BusinessValidator<T> {

    public void validator(T object) throws Exception;

}
