package com.github.dumock.config.datasource;

import com.github.jettyrun.common.utils.type.ClassUtils;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jetty on 18/3/8.
 */
@Configuration
// 因为这个对象的扫描，需要在MyBatisConfig的后面注入，所以加上下面的注解
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        String basePackagePath=ClassUtils.getPackageName(this.getClass());
        mapperScannerConfigurer.setBasePackage(basePackagePath.substring(0, basePackagePath.lastIndexOf(".")));
        return mapperScannerConfigurer;
    }
}