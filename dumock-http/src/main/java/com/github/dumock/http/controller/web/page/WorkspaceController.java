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
public class WorkspaceController extends BaseController{

    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_INDEX,method = {RequestMethod.GET})
    public String index(){
        return DuMockHtmlFilePathConstants.WORKSPACE_INDEX;
    }


    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_INTERFACE_CONTROLLER,method = {RequestMethod.GET})
    public String interfaceController(){
        return DuMockHtmlFilePathConstants.WORKSPACE_INTERFACE_CONTROLLER;
    }


    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_INTERFACE_LIST,method = {RequestMethod.GET})
    public String interfaceList(){
        return DuMockHtmlFilePathConstants.WORKSPACE_INTERFACE_LIST;
    }


    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_MOCK_ADD,method = {RequestMethod.GET})
    public String mockAdd(){
        return DuMockHtmlFilePathConstants.WORKSPACE_MOCK_ADD;
    }

    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_MOCK_EDIT,method = {RequestMethod.GET})
    public String mockEdit(){
        return DuMockHtmlFilePathConstants.WORKSPACE_MOCK_EDIT;
    }

    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_MOCK_REFERENCE,method = {RequestMethod.GET})
    public String mockReference(){
        return DuMockHtmlFilePathConstants.WORKSPACE_MOCK_REFERENCE;
    }

    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_QUOTE_SYSTEM,method = {RequestMethod.GET})
    public String quoteSystem(){
        return DuMockHtmlFilePathConstants.WORKSPACE_QUOTE_SYSTEM;
    }

    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_SCENE_ADD,method = {RequestMethod.GET})
    public String sceneAdd(){
        return DuMockHtmlFilePathConstants.WORKSPACE_SCENE_ADD;
    }

    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_SCENE_GROUP,method = {RequestMethod.GET})
    public String sceneGroup(){
        return DuMockHtmlFilePathConstants.WORKSPACE_SCENE_GROUP;
    }

    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_SCENE_INTERFACE,method = {RequestMethod.GET})
    public String sceneInterface(){
        return DuMockHtmlFilePathConstants.WORKSPACE_SCENE_INTERFACE;
    }

    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_SYSTEM_ADD,method = {RequestMethod.GET})
    public String systemAdd(){
        return DuMockHtmlFilePathConstants.WORKSPACE_SYSTEM_ADD;
    }

    @RequestMapping(value = DuMockUrlConstants.WORKSPACE_UPLOAD_JAR,method = {RequestMethod.GET})
    public String uploadJar(){
        return DuMockHtmlFilePathConstants.WORKSPACE_UPLOAD_JAR;
    }
}
