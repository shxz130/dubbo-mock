package com.github.dumock.http.controller.web.page;

import com.github.dumock.constants.DuMockHtmlFilePathConstants;
import com.github.dumock.constants.DuMockUrlConstants;
import com.github.dumock.http.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jetty on 18/7/18.
 */
@Controller
public class DubboServiceController extends BaseController {

    @RequestMapping(value = DuMockUrlConstants.DUBBO_SERVICE_INDEX,method = {RequestMethod.GET})
    public String index(){
        return DuMockHtmlFilePathConstants.DUBBO_SERVICE_INDEX;
    }

}
