package com.github.jettyrun.common.utils.validator;

import com.github.jettyrun.common.utils.collection.CollectionUtils;
import com.github.jettyrun.common.utils.type.ObjectUtils;

import java.util.List;

/**
 * Created by jetty on 18/2/13.
 */
public class ValidatorTools {


    private ValidatorTools(){
    }


    public static void validate(List<BusinessValidatorBean> validatorBeanList) throws Exception{

        if(!CollectionUtils.isEmpty(validatorBeanList)){
            for(BusinessValidatorBean businessValidatorBean:validatorBeanList){
                businessValidatorBean.getBusinessValidator().validator(businessValidatorBean.getProxy());
            }
        }
    }

    public static void validate(BusinessValidatorBean businessValidatorBean) throws Exception{
        if(!ObjectUtils.isEmpty(businessValidatorBean)){
                businessValidatorBean.getBusinessValidator().validator(businessValidatorBean.getProxy());
        }
    }

}
