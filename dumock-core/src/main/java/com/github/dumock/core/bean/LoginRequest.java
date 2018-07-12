package com.github.dumock.core.bean;

import com.github.dumock.core.bean.parent.ActionRequest;
import com.github.jettyrun.common.utils.validator.NotBlack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jetty on 18/7/11.
 */
@AllArgsConstructor
@ToString(exclude = {"password"})
public class LoginRequest extends ActionRequest{

    @Getter
    @NotBlack
    private String loginName;
    @Getter
    private String password;


}
