package com.github.jettyrun.common.utils.validator;

import com.github.jettyrun.common.utils.collection.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jetty on 18/2/13.
 */
public class BusinessValidatorHandler {

    private static ThreadLocal<List<BusinessValidatorBean>> threadLocal =new ThreadLocal();

    public static void handle()throws Exception{
        try{
            ValidatorTools.validate(threadLocal.get());
        }finally {
            threadLocal.remove();
        }
    }


    public static void put(Object params,BusinessValidator businessValidator){
        if(CollectionUtils.isEmpty(threadLocal.get())){
            threadLocal.set(new ArrayList<BusinessValidatorBean>());
        }
        threadLocal.get().add(new BusinessValidatorBean(params,businessValidator));
    }

}
