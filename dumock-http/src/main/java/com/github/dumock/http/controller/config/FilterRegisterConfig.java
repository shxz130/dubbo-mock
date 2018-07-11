package com.github.dumock.http.controller.config;

import com.github.dumock.http.controller.filter.ExceptionHandlerFilter;
import com.github.dumock.http.controller.filter.LoginStatusFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jetty on 18/7/10.
 */
@Configuration
public class FilterRegisterConfig {

    @Bean
    public FilterRegistrationBean exceptionFiterRegister() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ExceptionHandlerFilter());
        registration.addUrlPatterns("/*");
        registration.setName("exceptionHandler");
        registration.setOrder(0);
        return registration;
    }

    @Bean
    public FilterRegistrationBean loginFilterRegister() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LoginStatusFilter());
        registration.addUrlPatterns("/*");
        registration.setName("loginStatusFilter");
        registration.setOrder(1);
        return registration;
    }


}
