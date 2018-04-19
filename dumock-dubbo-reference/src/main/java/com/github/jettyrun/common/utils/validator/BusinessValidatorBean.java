package com.github.jettyrun.common.utils.validator;

/**
 * Created by jetty on 18/2/13.
 */
public class BusinessValidatorBean {

    private Object proxy;

    private BusinessValidator businessValidator;

    public BusinessValidatorBean(Object proxy, BusinessValidator validator) {
        this.proxy = proxy;
        this.businessValidator = validator;
    }

    public Object getProxy() {
        return proxy;
    }

    public BusinessValidator getBusinessValidator() {
        return businessValidator;
    }
}
