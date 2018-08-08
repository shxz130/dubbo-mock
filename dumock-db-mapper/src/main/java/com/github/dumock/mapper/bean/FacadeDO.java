package com.github.dumock.mapper.bean;

import com.github.dumock.mapper.bean.parent.AbstractDO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jetty on 18/7/16.
 */
@Data
@NoArgsConstructor
public class FacadeDO extends AbstractDO{

    private String systemUniqueKey;

    private String name;

    private String description;

    private String version;


}


