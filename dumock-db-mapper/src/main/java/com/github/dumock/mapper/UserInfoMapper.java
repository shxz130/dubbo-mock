package com.github.dumock.mapper;

import com.github.dumock.mapper.bean.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by jetty on 18/7/11.
 */
@Mapper
public interface UserInfoMapper {

    @Select("SELECT LOGIN_NAME as loginName,USER_NAME as userName,USER_PWD as userPwd FROM DUMOCK_D_USER_INFO WHERE LOGIN_NAME=#{loginName}")
    UserInfoDO queryOneByLoginName(String loginName);


}
