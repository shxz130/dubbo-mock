package com.github.dumock.service.db;

import com.github.dumock.copy.DuMockBeanCopyUtils;
import com.github.dumock.mapper.bean.JarFileDO;
import com.github.dumock.mapper.bean.UserInfoDO;
import com.github.dumock.service.db.bean.JarFile;
import com.github.dumock.service.db.bean.UserInfo;

/**
 * Created by jetty on 18/7/16.
 */
public interface JarFileService {



    public default JarFile convertDO2BO(JarFileDO jarFileDO){
        return DuMockBeanCopyUtils.copyOne2One(jarFileDO, JarFile.class);
    }

    public default JarFileDO convertBO2DO(JarFile jarFile){
        return DuMockBeanCopyUtils.copyOne2One(jarFile, JarFileDO.class);
    }

}
