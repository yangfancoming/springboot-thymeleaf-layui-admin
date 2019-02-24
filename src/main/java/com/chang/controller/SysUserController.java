package com.chang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chang .
 * Date: 2019/2/4
 * Time: 17:38
 * Description: To change this TemplateController use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/sysuser")
public class SysUserController {

    private final Logger logger = LoggerFactory.getLogger(SysUserController.class);
}
