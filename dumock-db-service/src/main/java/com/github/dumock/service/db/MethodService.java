package com.github.dumock.service.db;

import com.github.dumock.copy.DuMockBeanCopyUtils;
import com.github.dumock.mapper.bean.MethodDO;
import com.github.dumock.mapper.bean.SystemDO;
import com.github.dumock.service.db.bean.*;
import com.github.dumock.service.db.bean.System;

/**
 * Created by jetty on 18/7/16.
 */
public interface MethodService {

    public default Method convertDO2BO(MethodDO methodDO){
        return DuMockBeanCopyUtils.copyOne2One(methodDO, Method.class);
    }

    public default MethodDO convertBO2DO(Method method){
        return DuMockBeanCopyUtils.copyOne2One(method, MethodDO.class);
    }
}
