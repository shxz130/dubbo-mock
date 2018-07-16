package com.github.dumock.http.controller.web.rest;

import com.github.dumock.constants.DuMockUrlConstants;
import com.github.dumock.core.bean.LoginRequest;
import com.github.dumock.core.bean.parent.ActionResponse;
import com.github.dumock.core.action.login.LoginAction;
import com.github.dumock.http.controller.common.bean.parent.UserVO;
import com.github.dumock.result.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jetty on 18/6/29.
 */
@RestController
public class LoginRestController {

    @Autowired
    private LoginAction loginAction;

    @RequestMapping(value = DuMockUrlConstants.LOGIN_JSON,method = {RequestMethod.POST})
    public RequestResult uploadJar(UserVO userVO){
        loginAction.handle(new LoginRequest(userVO.getLoginName(),userVO.getPassword()),new ActionResponse());
        return RequestResult.success();
    }



}
