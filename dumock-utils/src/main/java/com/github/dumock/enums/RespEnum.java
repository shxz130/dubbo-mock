package com.github.dumock.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Created by jetty on 18/6/29.
 */

@AllArgsConstructor
public enum  RespEnum {

    SUCCESS("000000","成功"),
    ERROR("100999","系统内部异常"),
    FILE_IS_NOT_JAR("100001","文件非jar包"),
    JAR_IS_LAST_TIME("100002","jar包不是最新版本的jar"),
    LOGIN_STATUS_IS_LOSED("100003","登录态丢失"),
    PARAM_IS_EMPTY("100004","请求参数不能为空"),
    PARAM_IS_ERROR("100005","请求参数出错"),
    SQL_EXECUTE_ERROR("100006","sql执行出错"),
    BEAN_COPY_ERROR("100007","bean拷贝出错"),
    USER_IS_NOT_EXSITED("100008","用户不存在"),
    USER_PWD_IS_ERROR("100009","用户密码出错"),

    ;
    @Getter
    private String code;
    @Getter
    private String memo;


}
