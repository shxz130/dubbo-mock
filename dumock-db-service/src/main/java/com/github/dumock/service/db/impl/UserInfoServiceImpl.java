package com.github.dumock.service.db.impl;

import com.github.dumock.enums.RespEnum;
import com.github.dumock.exception.DuMockRunTimeException;
import com.github.dumock.mapper.UserInfoMapper;
import com.github.dumock.mapper.bean.UserInfoDO;
import com.github.dumock.service.db.bean.UserInfo;
import com.github.dumock.service.db.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jetty on 18/7/11.
 */
@Component
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo queryByLoginName(String loginName) {
        UserInfoDO userDO=null;
        try{
            userDO=userInfoMapper.queryOneByLoginName(loginName);
        }catch (Exception e){
            throw new DuMockRunTimeException(RespEnum.SQL_EXECUTE_ERROR,e);
        }
        return convertDO2BO(userDO);
    }
}
