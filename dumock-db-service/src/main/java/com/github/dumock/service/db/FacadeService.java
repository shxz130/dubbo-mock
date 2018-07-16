package com.github.dumock.service.db;

import com.github.dumock.copy.DuMockBeanCopyUtils;
import com.github.dumock.mapper.bean.FacadeDO;
import com.github.dumock.mapper.bean.MethodDO;
import com.github.dumock.service.db.bean.Facade;
import com.github.dumock.service.db.bean.Method;

/**
 * Created by jetty on 18/7/16.
 */
public interface FacadeService {


    public default Facade convertDO2BO(FacadeDO facadeDO){
        return DuMockBeanCopyUtils.copyOne2One(facadeDO, Facade.class);
    }

    public default FacadeDO convertBO2DO(Facade facade){
        return DuMockBeanCopyUtils.copyOne2One(facade, FacadeDO.class);
    }
}
