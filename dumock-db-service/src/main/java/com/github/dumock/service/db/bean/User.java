package com.github.dumock.service.db.bean;

import lombok.*;

/**
 * Created by jetty on 18/7/11.
 */
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class User {

    @NonNull
    private String loginName;
    private String userName;
    private String userPwd;

}
