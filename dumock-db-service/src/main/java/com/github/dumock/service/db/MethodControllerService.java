package com.github.dumock.service.db;

import com.github.dumock.copy.DuMockBeanCopyUtils;
import com.github.dumock.mapper.bean.MethodControllerDO;
import com.github.dumock.mapper.bean.MethodDO;
import com.github.dumock.service.db.bean.Method;
import com.github.dumock.service.db.bean.MethodController;

/**
 * Created by jetty on 18/7/16.
 */
public interface MethodControllerService {


    public default MethodController convertDO2BO(MethodControllerDO methodControllerDO){
        MethodController methodController= DuMockBeanCopyUtils.copyOne2One(methodControllerDO, MethodController.class);
        if(methodController!=null){
            methodController.setIsMock(MethodController.IsMock.valueOf(methodControllerDO.getIsMock()));
            methodController.setIsTimeOut(MethodController.IsTimeOut.valueOf(methodControllerDO.getIsTimeOut()));
        }
        return methodController;
    }

    public default MethodControllerDO convertBO2DO(MethodController methodController){
        MethodControllerDO methodControllerDO=DuMockBeanCopyUtils.copyOne2One(methodController, MethodControllerDO.class);
        if(methodControllerDO!=null){
            methodControllerDO.setIsMock(methodController.getIsMock().name());
            methodControllerDO.setIsTimeOut(methodController.getIsTimeOut().name());
        }
        return methodControllerDO;
    }
}
