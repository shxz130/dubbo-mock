package com.github.dumock.service.db;

import com.github.dumock.copy.DuMockBeanCopyUtils;
import com.github.dumock.mapper.bean.SystemDO;
import com.github.dumock.mapper.bean.UserInfoDO;
import com.github.dumock.service.db.bean.*;
import com.github.dumock.service.db.bean.System;

/**
 * Created by jetty on 18/7/16.
 */
public interface SystemService {






    public default System convertDO2BO(SystemDO systemDO){
        return DuMockBeanCopyUtils.copyOne2One(systemDO, System.class);
    }

    public default SystemDO convertBO2DO(System system){
        return DuMockBeanCopyUtils.copyOne2One(system, SystemDO.class);
    }

}
