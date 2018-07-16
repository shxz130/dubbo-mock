package com.github.dumock.mapper.bean;

import com.github.dumock.mapper.bean.parent.AbstractDO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jetty on 18/7/16.
 */
@NoArgsConstructor
@Data
public class MethodDO extends AbstractDO{

    private Long facadeId;
    private String description;
    private String paramType;
    private String returnType;
    private String paramJsonData;
    private String returnJsonData;

}
