package com.chang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ANdady on 2019/2/23.
 */
@Controller
@RequestMapping(value = "/sysrole")
public class SysRoleController {

    private final Logger logger = LoggerFactory.getLogger(SysRoleController.class);
}
