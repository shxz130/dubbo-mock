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
@ToString
@Data
public class CallResult extends AbstractBO {

    private String result;

}
