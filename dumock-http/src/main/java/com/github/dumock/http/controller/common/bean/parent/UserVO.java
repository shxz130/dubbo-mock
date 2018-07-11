package com.github.dumock.http.controller.common.bean.parent;

import com.github.dumock.http.controller.common.bean.AbstractVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by jetty on 18/7/10.
 */
@NoArgsConstructor
public class UserVO extends AbstractVO {
    @Getter
    private String userName;
    @Getter
    private String password;
}
