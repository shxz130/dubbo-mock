package com.github.dumock.mapper.bean;

import com.github.dumock.mapper.bean.parent.AbstractDO;
import lombok.*;

/**
 * Created by jetty on 18/7/11.
 */
@NoArgsConstructor
@Data
public class UserDO extends AbstractDO {
    private String loginName;
    private String userName;
    private String userPwd;
}
