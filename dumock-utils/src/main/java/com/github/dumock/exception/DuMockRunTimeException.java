package com.github.dumock.exception;

import com.github.dumock.enums.RespEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jetty on 18/7/10.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DuMockRunTimeException extends RuntimeException {

    private String code;

    private String message;

    public DuMockRunTimeException(RespEnum respEnum) {
        this.code = respEnum.getCode();
        this.message=respEnum.getMemo();
    }

    public DuMockRunTimeException(RespEnum respEnum,Exception e) {
        super(String.format("code:%s,message:%s",respEnum.getCode(),respEnum.getMemo()),e);
        this.code = respEnum.getCode();
        this.message=respEnum.getMemo();

    }
}
