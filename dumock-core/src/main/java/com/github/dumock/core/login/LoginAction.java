package com.github.dumock.core.login;

import com.github.dumock.core.bean.LoginRequest;
import com.github.dumock.core.bean.parent.ActionResponse;
import com.github.dumock.core.handler.BaseAction;
import com.github.dumock.enums.RespEnum;
import com.github.dumock.exception.DuMockRunTimeException;
import com.github.dumock.service.db.bean.User;
import com.github.dumock.service.db.login.UserInfoService;
import com.github.jettyrun.common.utils.encrypt.DigestUtils;
import com.github.jettyrun.common.utils.type.ObjectUtils;
import com.github.jettyrun.common.utils.type.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by jetty on 18/7/11.
 */
@Component
public class LoginAction extends BaseAction<LoginRequest,ActionResponse> {

    @Autowired
    private UserInfoService userInfoService;


    @Override
    protected void doHandle(LoginRequest loginRequest, ActionResponse actionResponse, Map map) {
        User user =userInfoService.queryByLoginName(loginRequest.getLoginName());
        if(ObjectUtils.isEmpty(user)){
            throw new DuMockRunTimeException(RespEnum.USER_IS_NOT_EXSITED);
        }

        if(!StringUtils.isBlank(user.getUserPwd())&&!user.getUserPwd().equals(DigestUtils.md5Digest(loginRequest.getPassword()))){
            throw new DuMockRunTimeException(RespEnum.USER_PWD_IS_ERROR);
        }

    }
}
