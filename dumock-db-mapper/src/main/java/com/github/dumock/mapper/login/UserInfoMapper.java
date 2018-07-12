package com.github.dumock.mapper.login;

import com.github.dumock.mapper.bean.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by jetty on 18/7/11.
 */
@Mapper
public interface UserInfoMapper {

    @Select("SELECT LOGIN_NAME,USER_NAME,USER_PWD FROM DUMOCK_D_USER_INFO WHERE LOGIN_NAME=#{loginName}")
    UserDO queryOneByLoginName(String loginName);


}
