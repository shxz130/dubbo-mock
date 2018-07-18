package com.github.dumock.core.handler;

import com.github.dumock.core.bean.parent.ActionRequest;
import com.github.dumock.core.bean.parent.ActionResponse;
import com.github.dumock.enums.RespEnum;
import com.github.dumock.exception.DuMockRunTimeException;
import com.github.jettyrun.common.utils.validator.BusinessValidator;
import com.github.jettyrun.common.utils.validator.BusinessValidatorHandler;
import com.github.jettyrun.common.utils.validator.ParamChecker;

import java.util.Map;

/**
 * Created by jetty on 18/6/29.
 */
public abstract class BaseAction<T extends ActionRequest,F extends ActionResponse>  extends ActionHandler<T,F>{

    private Map<String,BusinessValidator> validatorMap;

    @Override
    protected void before(T t, F f, Map map) {

    }

    @Override
    protected void after(T t, F f, Map map) {

    }

    @Override
    protected void check(T t, F f, Map map) {
        try{
            ParamChecker.check(t);
        }catch (Exception e){
            throw new DuMockRunTimeException(RespEnum.PARAM_IS_EMPTY);
        }
    }


    protected void put(Object params,BusinessValidator businessValidator){
        BusinessValidatorHandler.put(params,businessValidator);
    }

    protected  void validator(){
        try{
            BusinessValidatorHandler.handle();
        }catch (DuMockRunTimeException e){
            throw e;
        }catch (Exception e){
            throw new DuMockRunTimeException(RespEnum.ERROR,e);
        }
    }


}
