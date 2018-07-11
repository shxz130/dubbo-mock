package com.github.dumock.http.controller.filter;

import com.alibaba.fastjson.JSON;
import com.github.dumock.constants.DuMockUrlConstants;
import com.github.dumock.enums.RespEnum;
import com.github.dumock.exception.DuMockRunTimeException;
import com.github.dumock.result.RequestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jetty on 18/7/10.
 */
public class ExceptionHandlerFilter implements Filter {

    private static Logger logger= LoggerFactory.getLogger(LoginStatusFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try{
            filterChain.doFilter(servletRequest,servletResponse);
        }catch (Exception e){
            logger.error("业务逻辑处理出错",e);
            dealException((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, e);
        }
    }

    @Override
    public void destroy() {

    }

    private void dealException(HttpServletRequest servletRequest,HttpServletResponse response,Exception e){
        if((isJSONInterface((HttpServletRequest)servletRequest))){
            try{
                response.getWriter().write(JSON.toJSONString(RequestResult.fail()));
            }catch(Exception e1){
                logger.error("返回信息写失败",e1);
            }
        }else{
            try{
                response.sendRedirect(servletRequest.getContextPath()+DuMockUrlConstants.ERROR_500);
                return;
            }catch (Exception e1){
                logger.error("返回信息写失败",e1);
            }
        }
    }

    private boolean isLoginException(Exception e){
        if(e instanceof DuMockRunTimeException){
            if(((DuMockRunTimeException) e).getCode().equals(RespEnum.LOGIN_STATUS_IS_LOSED.getCode())){
                return true;
            }
        }
        return false;
    }

    private String getContextPath(HttpServletRequest servletRequest){
        return servletRequest.getServletPath();
    }


    private Boolean isJSONInterface(HttpServletRequest servletRequest){
        return getContextPath(servletRequest).endsWith(".json");
    }
}
