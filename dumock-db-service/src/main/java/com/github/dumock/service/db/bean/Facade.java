package com.github.dumock.service.db.bean;

import com.github.dumock.mapper.bean.parent.AbstractDO;
import com.github.dumock.service.db.bean.parent.AbstractBO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jetty on 18/7/16.
 */
@Data
@NoArgsConstructor
public class Facade extends AbstractBO {

    private String systemUniqueKey;
    private String name;
    private String description;
    private String version;


}


