package com.github.dumock.mapper.bean;

import lombok.*;

/**
 * Created by jetty on 18/7/11.
 */
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class UserDO {

    @NonNull
    private String loginName;
    private String userName;
    private String userPwd;
}
