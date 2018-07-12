package com.github.dumock.service.db.login.impl;

import com.github.dumock.copy.DuMockBeanCopyUtils;
import com.github.dumock.enums.RespEnum;
import com.github.dumock.exception.DuMockRunTimeException;
import com.github.dumock.mapper.bean.UserDO;
import com.github.dumock.mapper.login.UserInfoMapper;
import com.github.dumock.service.db.bean.User;
import com.github.dumock.service.db.login.UserInfoService;
import com.github.jettyrun.common.utils.bean.copier.BeanCopierUtils;
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
    public User queryByLoginName(String loginName) {
        UserDO userDO=null;
        try{
            userDO=userInfoMapper.queryOneByLoginName(loginName);
        }catch (Exception e){
            throw new DuMockRunTimeException(RespEnum.SQL_EXECUTE_ERROR,e);
        }
        return DuMockBeanCopyUtils.copyOne2One(userDO, User.class);
    }
}
