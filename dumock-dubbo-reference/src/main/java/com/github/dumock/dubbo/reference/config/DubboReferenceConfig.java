package com.github.dumock.dubbo.reference.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.dumock.constants.DuMockOutterFileConstants;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by jetty on 18/3/8.
 */
@Configuration
@PropertySource(DuMockOutterFileConstants.DUMOCK_DUBBO_REFERENCE_FILE_PATH)
@ToString
public class DubboReferenceConfig {

    @Value("${dubbo.application.name}")
    @Getter
    private  String applicationName;

    @Value("${dubbo.application.owner}")
    @Getter
    private  String applicationOwner;


    @Value("${dubbo.reference.registry.address}")
    @Getter
    private  String registryAddress;


}
