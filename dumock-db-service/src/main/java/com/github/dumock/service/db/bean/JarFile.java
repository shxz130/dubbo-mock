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
public class JarFile extends AbstractBO {

    private String groupId;
    private String artifactId;
    private String systemUniqueKey;
    private String version;
    private String jarFileName;
    private String jarFilePath;


}
