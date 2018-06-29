package com.github.dumock.core.file;

import com.github.dumock.core.bean.UploadFileRequest;
import com.github.dumock.core.bean.parent.ActionRequest;
import com.github.dumock.core.bean.parent.ActionResponse;
import com.github.dumock.core.exception.DuMockRuntimeException;
import com.github.dumock.core.handler.BaseAction;
import com.github.dumock.core.validator.JarIsLastTimeValidator;
import com.github.jettyrun.common.utils.validator.BusinessValidator;
import com.github.jettyrun.common.utils.validator.BusinessValidatorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.jvm.hotspot.debugger.dummy.DummyDebugger;

import java.util.Map;

/**
 * Created by jetty on 18/6/29.
 */
@Component
public class FileUploadAction extends BaseAction<UploadFileRequest,ActionResponse>{

    @Autowired
    private JarIsLastTimeValidator jarIsLastTimeValidator;


    @Override
    protected void check(UploadFileRequest uploadFileRequest, ActionResponse actionResponse, Map map) {
        super.check(uploadFileRequest, actionResponse, map);
        BusinessValidatorHandler.put(uploadFileRequest.getFile(), jarIsLastTimeValidator);
        validator();
    }

    @Override
    protected void doHandle(UploadFileRequest uploadFileRequest, ActionResponse actionResponse, Map map) {

    }
}
