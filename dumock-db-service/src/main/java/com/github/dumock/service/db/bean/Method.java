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
public class Method extends AbstractBO {

    private Long facadeId;
    private String description;
    private String paramType;
    private String returnType;
    private String paramJsonData;
    private String returnJsonData;

}
