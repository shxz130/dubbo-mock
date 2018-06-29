package com.github.dumock.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Created by jetty on 18/6/29.
 */

@AllArgsConstructor

public enum  RespEnum {

    SUCCESS("100000","成功"),
    ERROR("100999","系统内部异常"),
    FILE_IS_NOT_JAR("100001","文件非jar包"),
    JAR_IS_LAST_TIME("100002","jar包不是最新版本的jar"),
    ;
    @Getter
    private String code;
    @Getter
    private String memo;


}
