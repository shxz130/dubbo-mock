package com.github.dumock.result;

import com.github.dumock.enums.RespEnum;
import lombok.*;

import java.beans.ConstructorProperties;

/**
 * Created by jetty on 18/6/29.
 */
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@RequiredArgsConstructor
public class RequestResult<T> extends AbstractResquestResult{

    private T data;

    public static RequestResult success(){
        return new RequestResult(RespEnum.SUCCESS.getCode(),RespEnum.SUCCESS.getMemo(),null);
    }

    public static RequestResult fail(){
        return new RequestResult(RespEnum.ERROR.getCode(),RespEnum.ERROR.getMemo(),null);
    }

    public RequestResult(String code, String message, T data) {
        super(code, message);
        this.data = data;
    }
}
