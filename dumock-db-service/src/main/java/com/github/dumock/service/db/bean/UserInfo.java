package com.github.dumock.service.db.bean;

import com.github.dumock.service.db.bean.parent.AbstractBO;
import lombok.*;

/**
 * Created by jetty on 18/7/11.
 */
@NoArgsConstructor
@Data
public class UserInfo extends AbstractBO {

    private String loginName;
    private String userName;
    private String userPwd;

}
