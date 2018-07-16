package com.github.dumock.http.controller.filter;

import com.github.jettyrun.common.utils.type.ObjectUtils;

/**
 * Created by jetty on 18/7/16.
 */
public class LoggerHelper {

    private static ThreadLocal<Object> objectThreadLocal=new ThreadLocal<>();


    public static void put(Object object){
        if(objectThreadLocal.get()!=null){
            objectThreadLocal.remove();
        }
        objectThreadLocal.set(object);
    }
    public static Object get(){
        try{
            return objectThreadLocal.get();
        }finally {
            objectThreadLocal.remove();
        }
    }


}
