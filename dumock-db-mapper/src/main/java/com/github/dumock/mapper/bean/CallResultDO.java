package com.github.dumock.mapper.bean;

import com.github.dumock.mapper.bean.parent.AbstractDO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by jetty on 18/7/16.
 */
@NoArgsConstructor
@ToString
@Data
public class CallResultDO extends AbstractDO {

    private String result;

}
