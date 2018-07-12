package com.github.dumock.copy;

import com.github.dumock.enums.RespEnum;
import com.github.dumock.exception.DuMockRunTimeException;
import com.github.jettyrun.common.utils.bean.copier.BeanCopierUtils;
import com.github.jettyrun.common.utils.collection.CollectionUtils;
import com.github.jettyrun.common.utils.type.ObjectUtils;

import java.util.List;

/**
 * Created by jetty on 18/7/11.
 */
public final class DuMockBeanCopyUtils {


    public static <T> T copyOne2One(Object source, Class<T> target) {

        if(ObjectUtils.isEmpty(source)){
            return null;
        }
        try{
            return BeanCopierUtils.copyOne2One(source,target);
        }catch (Exception e){
            throw new DuMockRunTimeException(RespEnum.BEAN_COPY_ERROR,e);
        }
    }

    public static <T> List<T> copyList2List(List<?> source, Class<T> target){
        if(CollectionUtils.isEmpty(source)){
            return null;
        }
        try{
            return BeanCopierUtils.copyList2List(source, target);
        }catch (Exception e){
            throw new DuMockRunTimeException(RespEnum.BEAN_COPY_ERROR,e);
        }
    }

}
