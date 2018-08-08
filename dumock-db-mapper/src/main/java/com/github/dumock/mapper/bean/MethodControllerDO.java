package com.github.dumock.mapper.bean;

import com.github.dumock.mapper.bean.parent.AbstractDO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jetty on 18/7/16.
 */
@NoArgsConstructor
@Data
public class MethodControllerDO extends AbstractDO{

    private Long methodId;

    private String userName;

    private String isMock;

    private String isTimeOut;

    private String timeOutLength;

}
