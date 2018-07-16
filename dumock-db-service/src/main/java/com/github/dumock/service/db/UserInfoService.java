package com.github.dumock.service.db;

import com.github.dumock.copy.DuMockBeanCopyUtils;
import com.github.dumock.mapper.bean.UserInfoDO;
import com.github.dumock.service.db.bean.UserInfo;

/**
 * Created by jetty on 18/7/11.
 */
public interface UserInfoService {

    public UserInfo queryByLoginName(String loginName);


    public default UserInfo convertDO2BO(UserInfoDO userInfoDO){
        return DuMockBeanCopyUtils.copyOne2One(userInfoDO, UserInfo.class);
    }

    public default UserInfoDO convertBO2DO(UserInfo userInfo){
        return DuMockBeanCopyUtils.copyOne2One(userInfo, UserInfoDO.class);
    }
}
