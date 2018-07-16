package com.github.dumock.constants;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jetty on 18/7/10.
 */
public class DuMockConstants {

    public static final String DUMOCK_ACCESS_TOKEN_KEY="ACCESS_TOKEN";

    public static final String ACCESS_TOKEN_AES_KEY="E64313FD3B98FE5EBCAB7F23ADF94CBDCA294DC5DEF1369E";

    public static final List<String> LOGIN_WHITE_LIST= Arrays.asList(new String[]{DuMockUrlConstants.LOGIN, DuMockUrlConstants.LOGIN_JSON});

    public static final List<String> NOT_STATIC_RESOURCE_LIST=Arrays.asList(new String[]{"json","jsp"});

    public static final List<String> COMMON_PAGE_LIST=Arrays.asList(new String[]{DuMockUrlConstants.ERROR_500,DuMockUrlConstants.ERROR_404});

    public static final List<String> NEED_MARK_PARAM_KEY= Arrays.asList(new String[]{"file", "password"});

    public static final Integer TOKEN_EXPIRED_TIME=30*60*1000;


}
