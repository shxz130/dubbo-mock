package com.github.dumock.http.controller.filter;

import com.alibaba.fastjson.JSON;
import com.github.dumock.constants.DuMockConstants;
import com.github.jettyrun.common.utils.threadlocal.WebContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by jetty on 18/7/16.
 */
public class LoggerFilter implements Filter {


    private static Logger logger= LoggerFactory.getLogger(LoginStatusFilter.class);



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(isStaticResouce((HttpServletRequest)servletRequest)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            WebContext.register((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
            try{
                long startTime=System.currentTimeMillis();
                recordLog((HttpServletRequest) servletRequest);
                filterChain.doFilter(servletRequest, servletResponse);
                recordResultLog((HttpServletRequest)servletRequest,System.currentTimeMillis()-startTime);
            }finally {
                WebContext.remove();
            }
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isStaticResouce(HttpServletRequest request){
        String path=getContextPath(request);
        return !DuMockConstants.NOT_STATIC_RESOURCE_LIST.contains(path.substring(path.lastIndexOf(".") + 1));
    }

    private void recordResultLog(HttpServletRequest servletRequest,long times){
        Object object=LoggerHelper.get();
        String json=object==null?null:JSON.toJSONString(object);
        logger.info(String.format("请求地址:%s,返回参数:%s,耗时:%sms",getUrlFromServletRequest(servletRequest),json,times));
    }

    private String getContextPath(HttpServletRequest servletRequest){
        return servletRequest.getServletPath();
    }


    private void recordLog(HttpServletRequest servletRequest) {
        String requestUrl = getUrlFromServletRequest(servletRequest);
        Map<String, String[]> paramsData = getParams(servletRequest);
        logger.info(String.format("请求地址:%s,请求参数:%s",requestUrl,JSON.toJSONString(paramsData)));
    }


    private String getUrlFromServletRequest(HttpServletRequest request){
        return request.getRequestURL().toString();
    }

    private Map<String,String[]> getParams(HttpServletRequest request){
        Map<String, String[]> paramsData = new HashMap<>(request.getParameterMap());
        DuMockConstants.NEED_MARK_PARAM_KEY.forEach((key) -> {
                    if (paramsData.containsKey(key)) {
                        paramsData.put(key, mark(key));
                    }
                }
        );
        return paramsData;
    };

    private String[] mark(Object o) {
        return new String[]{"******"};

    }
}
