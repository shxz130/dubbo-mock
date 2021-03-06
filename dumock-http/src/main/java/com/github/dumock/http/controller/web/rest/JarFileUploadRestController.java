package com.github.dumock.http.controller.web.rest;

import com.github.dumock.constants.DuMockUrlConstants;
import com.github.dumock.core.bean.UploadFileRequest;
import com.github.dumock.core.bean.parent.ActionResponse;
import com.github.dumock.core.action.file.FileUploadAction;
import com.github.dumock.result.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jetty on 18/6/29.
 */
@RestController
public class JarFileUploadRestController {

    @Autowired
    private FileUploadAction fileUploadAction;

    @RequestMapping(value = DuMockUrlConstants.UPLOAD_JAR_FILE_PATH,method = {RequestMethod.GET,RequestMethod.POST})
    public RequestResult uploadJar(@RequestParam(value = "file",required = true)MultipartFile file){
        fileUploadAction.handle(new UploadFileRequest(file),new ActionResponse());
        return RequestResult.success();
    }
}
