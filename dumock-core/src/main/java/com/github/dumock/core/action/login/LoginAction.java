package com.github.dumock.core.action.login;

import com.github.dumock.constants.DuMockConstants;
import com.github.dumock.core.bean.LoginRequest;
import com.github.dumock.core.bean.parent.ActionResponse;
import com.github.dumock.core.handler.BaseAction;
import com.github.dumock.service.db.bean.UserInfo;
import com.github.dumock.service.db.UserInfoService;
import com.github.jettyrun.common.utils.encrypt.CipherAESUtils;
import com.github.jettyrun.common.utils.threadlocal.WebContext;
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
        UserInfo user =userInfoService.queryByLoginName(loginRequest.getLoginName());
//        if(ObjectUtils.isEmpty(user)){
//            throw new DuMockRunTimeException(RespEnum.USER_IS_NOT_EXSITED);
//        }
//
//        if(!StringUtils.isBlank(user.getUserPwd())&&!user.getUserPwd().equals(DigestUtils.md5Digest(loginRequest.getPassword()))){
//            throw new DuMockRunTimeException(RespEnum.USER_PWD_IS_ERROR);
//        }
        WebContext.writeNewCookie(DuMockConstants.DUMOCK_ACCESS_TOKEN_KEY, CipherAESUtils.getEncrypt4Aes("zhangbo583",DuMockConstants.ACCESS_TOKEN_AES_KEY),null,null,DuMockConstants.TOKEN_EXPIRED_TIME);

    }
}
