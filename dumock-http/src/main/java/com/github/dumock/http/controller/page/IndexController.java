package com.github.dumock.http.controller.page;

import com.github.dumock.constants.DuMockHtmlFilePathConstants;
import com.github.dumock.constants.DuMockUrlConstants;
import com.github.dumock.http.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jetty on 18/7/10.
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = DuMockUrlConstants.INDEX,method = {RequestMethod.GET})
    public String index(){
        return DuMockHtmlFilePathConstants.INDEX;
    }
}
