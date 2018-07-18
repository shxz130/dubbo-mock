package com.github.dumock.core.validator;

import com.github.dumock.enums.RespEnum;
import com.github.dumock.exception.DuMockRunTimeException;
import com.github.dumock.tools.PreConditionTools;
import com.github.jettyrun.common.utils.validator.BusinessValidator;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jetty on 18/6/29.
 */

@Component
public class JarIsLastTimeValidator implements BusinessValidator<MultipartFile> {



    @Override
    public void validator(MultipartFile object) throws Exception {
        PreConditionTools.checkState(object.getOriginalFilename().endsWith(".jar"),RespEnum.FILE_IS_NOT_JAR);
        Integer originVersionNumber=getVersionByDB(object);
        Integer jarVersionNumber=getVersionByJar(object);
        PreConditionTools.checkState(jarVersionNumber>=originVersionNumber,RespEnum.JAR_IS_LAST_TIME);
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
