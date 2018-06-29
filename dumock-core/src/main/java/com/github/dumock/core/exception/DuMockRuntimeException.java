package com.github.dumock.core.exception;

import com.github.dumock.enums.RespEnum;
import com.github.jettyrun.common.utils.exception.ExceptionUtils;
import lombok.*;

/**
 * Created by jetty on 18/6/29.
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class DuMockRuntimeException extends RuntimeException{
    @NonNull
    private String code;
    @NonNull
    private String message;

    private Exception e;

    public DuMockRuntimeException(RespEnum respEnum,Exception e) {
        this.code = respEnum.getCode();
        this.message = respEnum.getMemo();
        this.e=e;
    }

    public DuMockRuntimeException(RespEnum respEnum) {
        this.code = respEnum.getCode();
        this.message = respEnum.getMemo();
    }
}
