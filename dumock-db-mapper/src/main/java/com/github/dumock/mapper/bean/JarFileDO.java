package com.github.dumock.mapper.bean;

import com.github.dumock.mapper.bean.parent.AbstractDO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jetty on 18/7/16.
 */
@NoArgsConstructor
@Data
public class JarFileDO extends AbstractDO{

    private String groupId;

    private String artifactId;

    private String systemUniqueKey;

    private String version;

    private String jarFileName;

    private String jarFilePath;


}
