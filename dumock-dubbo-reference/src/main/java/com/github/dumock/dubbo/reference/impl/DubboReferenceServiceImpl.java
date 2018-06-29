package com.github.dumock.dubbo.reference.impl;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.github.dumock.dubbo.reference.DubboReferenceService;
import com.github.dumock.dubbo.reference.config.DubboReferenceConfig;
import com.github.jettyrun.common.utils.type.ObjectUtils;
import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jetty on 18/6/29.
 */
@Component
public class DubboReferenceServiceImpl implements DubboReferenceService {

    private static final Logger logger= LoggerFactory.getLogger(DubboReferenceServiceImpl.class);

    @Override
    public Object reference(String interfaceName, String group, String version,boolean isGeneric) {
        ReferenceConfig referenceConfig=initReferenceConfig(isGeneric);
        referenceConfig.setInterface(interfaceName);
        referenceConfig.setGroup(group);
        referenceConfig.setVersion(version);
        Object result=null;
        try{
            result= referenceConfig.get();

        }catch (Exception e){
            logger.error("引用服务失败,interface={},group={},version={}",interfaceName,group,version,e);
            if(isGeneric){
                result=initDefaultResult();
            }
        }
        return result;
    }


    private ReferenceConfig initReferenceConfig(boolean isGeneric){
        ReferenceConfig referenceConfig=new ReferenceConfig();
        referenceConfig.setGeneric(isGeneric);
        referenceConfig.setApplication(initApplication());
        referenceConfig.setRegistries(initRegistries());
        return referenceConfig;
    }


    /**
     * 初始化应用config
     *
     * @return
     */
    private ApplicationConfig initApplication(){
        ApplicationConfig applicationConfig=new ApplicationConfig();
        applicationConfig.setName(DubboReferenceConfig.getApplicationName());
        applicationConfig.setOwner(DubboReferenceConfig.getApplicationOwner());
        return applicationConfig;
    }

    /**
     * 初始化注册中心
     *
     * @return
     */
    private List<RegistryConfig> initRegistries(){
        List<String> registryAddresses=Splitter.on(",").trimResults().splitToList(DubboReferenceConfig.getRegistryAddress());
        List<RegistryConfig> registryConfigList=new ArrayList<>();
        for(String registryAddress:registryAddresses){
            RegistryConfig registryConfig=new RegistryConfig();
            registryConfig.setAddress(registryAddress);
            registryConfigList.add(registryConfig);
        }
        return registryConfigList;
    }

    /**
     * 泛化引用返回默认结果
     *
     * @return
     */
    private Object initDefaultResult(){
        return new GenericService(){
            @Override
            public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
                Map datamap=new HashMap<String,String>();
                datamap.put("code","error");
                datamap.put("respCode","error");
                datamap.put("memo","服务不可用");
                datamap.put("respMemo","服务不可用");
                return datamap;
            }
        };
    }
}
