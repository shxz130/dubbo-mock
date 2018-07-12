package com.github.dumock.service.db.login;

import com.github.dumock.service.db.bean.User;

/**
 * Created by jetty on 18/7/11.
 */
public interface UserInfoService {

    public User queryByLoginName(String loginName);

}
