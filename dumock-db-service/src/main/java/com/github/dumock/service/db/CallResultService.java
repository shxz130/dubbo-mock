package com.github.dumock.service.db;

import com.github.dumock.copy.DuMockBeanCopyUtils;
import com.github.dumock.mapper.bean.CallResultDO;
import com.github.dumock.mapper.bean.MethodControllerDO;
import com.github.dumock.service.db.bean.CallResult;
import com.github.dumock.service.db.bean.MethodController;

/**
 * Created by jetty on 18/7/16.
 */
public interface CallResultService {

    public default CallResult convertDO2BO(CallResultDO callResultDO){
        return DuMockBeanCopyUtils.copyOne2One(callResultDO, CallResult.class);
    }

    public default CallResultDO convertBO2DO(CallResult callResult){
      return DuMockBeanCopyUtils.copyOne2One(callResult, CallResultDO.class);
    }
}
