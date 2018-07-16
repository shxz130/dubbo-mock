package com.github.dumock.service.db.bean;

import com.github.dumock.mapper.bean.parent.AbstractDO;
import com.github.dumock.service.db.bean.parent.AbstractBO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jetty on 18/7/16.
 */
@NoArgsConstructor
@Data
public class MethodController extends AbstractBO {

    private Long methodId;
    private String userName;
    private IsMock isMock;
    private IsTimeOut isTimeOut;
    private String timeOutLength;

    public enum IsMock{
        TRUE,
        FALSE
    }

    public enum IsTimeOut{
        TRUE,
        FALSE
    }
}
