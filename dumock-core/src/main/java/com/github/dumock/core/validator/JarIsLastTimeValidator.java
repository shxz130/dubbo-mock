package com.github.dumock.core.validator;

import com.github.dumock.core.exception.DuMockRuntimeException;
import com.github.dumock.enums.RespEnum;
import com.github.jettyrun.common.utils.validator.BusinessValidator;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jetty on 18/6/29.
 */

@Component
public class JarIsLastTimeValidator implements BusinessValidator<MultipartFile> {



    @Override
    public void validator(MultipartFile object) throws Exception {
        if(!object.getOriginalFilename().endsWith(".jar")){
            throw new DuMockRuntimeException(RespEnum.FILE_IS_NOT_JAR);
        }
        //TODO 获取数据库的jar
        Integer originVersionNumber=getVersionByDB(object);
        //TODO 获取最新的版本号
        Integer jarVersionNumber=getVersionByJar(object);
        if(jarVersionNumber<originVersionNumber){
            throw new DuMockRuntimeException(RespEnum.JAR_IS_LAST_TIME);
        }
    }

    /**
     *
     * @param object
     * @return
     */
    private Integer getVersionByJar(MultipartFile object){
        return 1;
    }

    /**
     *
     * @param object
     * @return
     */
    private Integer getVersionByDB(MultipartFile object){
        return 1;
    }
}
