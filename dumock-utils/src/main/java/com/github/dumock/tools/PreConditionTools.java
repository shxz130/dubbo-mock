package com.github.dumock.tools;

import com.github.dumock.enums.RespEnum;
import com.github.dumock.exception.DuMockRunTimeException;
import com.google.common.base.Preconditions;

/**
 * Created by jetty on 18/7/18.
 */
public final class PreConditionTools {

    public static final void checkState(boolean status,RespEnum respEnum){
        try{
            Preconditions.checkState(status);
        }catch (Exception e){
            throw new DuMockRunTimeException(respEnum,e);
        }
    }

    public static final void checkState(boolean status,RespEnum respEnum,String memo){
        try{
            Preconditions.checkState(status,memo);
        }catch (Exception e){
            throw new DuMockRunTimeException(respEnum,e);
        }
    }


    public static final void checkNotNull(Object o,RespEnum respEnum,String memo){
        try{
            Preconditions.checkNotNull(o, memo);
        }catch (Exception e){
            throw new DuMockRunTimeException(respEnum,e);
        }
    }

    public static final void checkNotNull(Object o,RespEnum respEnum){
        try{
            Preconditions.checkNotNull(o);
        }catch (Exception e){
            throw new DuMockRunTimeException(respEnum,e);
        }
    }

    public static final void checkArgument(boolean status,RespEnum respEnum){
        try{
            Preconditions.checkArgument(status);
        }catch (Exception e){
            throw new DuMockRunTimeException(respEnum,e);
        }
    }

    public static final void checkArgument(boolean status,RespEnum respEnum,String memo){
        try{
            Preconditions.checkArgument(status,memo);
        }catch (Exception e){
            throw new DuMockRunTimeException(respEnum,e);
        }
    }
}
