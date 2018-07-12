package com.github.dumock.http.controller.common.bean.parent;

import com.github.dumock.http.controller.common.bean.AbstractVO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by jetty on 18/7/10.
 */
@NoArgsConstructor
@ToString(exclude = {"password"})
@Data
public class UserVO extends AbstractVO {
    private String loginName;
    private String password;
}
