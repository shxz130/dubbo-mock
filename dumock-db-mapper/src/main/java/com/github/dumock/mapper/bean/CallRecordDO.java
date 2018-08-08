package com.github.dumock.mapper.bean;

import com.github.dumock.mapper.bean.parent.AbstractDO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by jetty on 18/7/16.
 */

@NoArgsConstructor
@ToString(callSuper = true)
@Data
public class CallRecordDO extends AbstractDO {

    private String userName;

    private String InterfaceName;

    private String methodName;

    private String isMock;

    private String isTimeOut;

    private String callStatus;

    private Long callResultId;
}
