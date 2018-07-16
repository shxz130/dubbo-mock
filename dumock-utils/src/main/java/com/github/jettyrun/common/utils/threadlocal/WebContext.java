package com.github.jettyrun.common.utils.threadlocal;

import com.github.dumock.constants.DuMockConstants;
import com.github.jettyrun.common.utils.encrypt.CipherAESUtils;
import com.github.jettyrun.common.utils.type.ObjectUtils;
import com.github.jettyrun.common.utils.type.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jetty on 18/7/16.
 */
public class WebContext {

    private static ThreadLocal<HttpServletRequest> requestThreadLocal=new ThreadLocal<>();

    private static ThreadLocal<HttpServletResponse> responseThreadLocal=new ThreadLocal<>();


    public static void register(HttpServletRequest httpServletRequest,HttpServletResponse response){
        requestThreadLocal.set(httpServletRequest);
        responseThreadLocal.set(response);
    }

    public static void getUserName(){

    }

    public static void remove(){
        requestThreadLocal.remove();
        responseThreadLocal.remove();
    }



    public static Map<String,Cookie> getCookieMapByRequest(HttpServletRequest servletRequest){
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = servletRequest.getCookies();
        if (!ObjectUtils.isEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    public static Cookie    getCookieByKey(String key){
        Map<String,Cookie> cookieMap=getCookieMapByRequest(requestThreadLocal.get());
        if(ObjectUtils.isEmpty(cookieMap)){
            return null;
        }
        return cookieMap.get(key);
    }

    public static String getCookieValueByKey(String key){
        Cookie cookie=getCookieByKey(key);
        if(ObjectUtils.isEmpty(cookie)){
            return null;
        }
        return cookie.getValue();
    }


    public static String getUserId(){
        return CipherAESUtils.getDecrypt4Aes2Str(getAccessToken(), DuMockConstants.ACCESS_TOKEN_AES_KEY);
    }


    public static String getAccessToken(){
        return getCookieValueByKey(DuMockConstants.DUMOCK_ACCESS_TOKEN_KEY);
    }


    /**
     * 构建新cookie
     * @param expiry null : cookie不要设置超时，默认关闭浏览器失效
     * @return
     */
    private static Cookie getNewCookie(String name,String value,String domain,String path,Integer expiry) {
        Cookie cookie=new Cookie(name,value);
        if(!StringUtils.isBlank(domain)){
            cookie.setDomain(domain);
        }
        if(!StringUtils.isBlank(path)){
            cookie.setPath(path);
        }
        if(ObjectUtils.isEmpty(expiry)){
            cookie.setMaxAge(expiry);
        }
        return cookie;
    }


    public static void writeNewCookie(String name,String value,String domain,String path,Integer expiry){
        responseThreadLocal.get().addCookie(getNewCookie(name,value,domain,path,expiry));
    }


}
