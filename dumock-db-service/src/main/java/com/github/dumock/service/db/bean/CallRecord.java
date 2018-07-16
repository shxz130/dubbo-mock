package com.github.dumock.service.db.bean;

import com.github.dumock.mapper.bean.parent.AbstractDO;
import com.github.dumock.service.db.bean.parent.AbstractBO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by jetty on 18/7/16.
 */

@NoArgsConstructor
@ToString(callSuper = true)
@Data
public class CallRecord extends AbstractBO {

    private String userName;
    private String InterfaceName;
    private String methodName;
    private IsMock isMock;
    private IsTimeOut isTimeOut;
    private CallStatus callStatus;
    private String callResult;
    private String callResultId;


    public enum CallStatus{
        PROCESS,
        SUCCESS,
        FAIL
    }

    public enum IsMock{
        TRUE,
        FALSE
    }

    public enum IsTimeOut{
        TRUE,
        FALSE
    }
}
