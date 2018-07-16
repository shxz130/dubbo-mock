package com.github.dumock.http.controller.filter;

import com.github.dumock.constants.DuMockConstants;
import com.github.dumock.constants.DuMockUrlConstants;
import com.github.dumock.enums.RespEnum;
import com.github.dumock.exception.DuMockRunTimeException;
import com.github.jettyrun.common.utils.encrypt.CipherAESUtils;
import com.github.jettyrun.common.utils.threadlocal.WebContext;
import com.github.jettyrun.common.utils.type.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jetty on 18/7/10.
 */

public class LoginStatusFilter implements Filter {

    private static Logger logger= LoggerFactory.getLogger(LoginStatusFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(isOnline((HttpServletRequest)servletRequest)||isLoginUrl((HttpServletRequest) servletRequest)||isStaticResouce((HttpServletRequest) servletRequest)||isCommonResources((HttpServletRequest) servletRequest)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            throw new DuMockRunTimeException(RespEnum.LOGIN_STATUS_IS_LOSED);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isLoginUrl(HttpServletRequest request){
       return DuMockConstants.LOGIN_WHITE_LIST.contains(getContextPath(request));
    }



    private boolean isStaticResouce(HttpServletRequest request){
        String path=getContextPath(request);
        return !DuMockConstants.NOT_STATIC_RESOURCE_LIST.contains(path.substring(path.lastIndexOf(".") + 1));
    }



    private String getContextPath(HttpServletRequest servletRequest){
        return servletRequest.getServletPath();
    }


    private boolean isOnline(HttpServletRequest servletRequest){
        String accessToken= WebContext.getAccessToken();
        if(StringUtils.isBlank(accessToken)) {
            return false;
        }
        try{
            CipherAESUtils.getDecrypt4Aes2Str(accessToken,DuMockConstants.ACCESS_TOKEN_AES_KEY);
        }catch (Exception e){
            logger.error("解密出错",e);
            return false;
        }
        return true;
    }


    private String getAccessToken(HttpServletRequest servletRequest){
        Cookie[] cookies= servletRequest.getCookies();
        if(null==cookies){
            return null;
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals(DuMockConstants.DUMOCK_ACCESS_TOKEN_KEY)){
                return cookie.getValue();
            }
        }
        return null;
    }


    private boolean isCommonResources(HttpServletRequest servletRequest){
        return DuMockConstants.COMMON_PAGE_LIST.contains(getContextPath(servletRequest));
    }

}
