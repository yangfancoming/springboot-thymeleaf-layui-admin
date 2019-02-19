package com.chang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chang .
 * Date: 2019/2/4
 * Time: 17:38
 * Description: To change this TemplateController use File | Settings | File Templates.
 */
@Controller
public class MenuController {

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/menu/console")
    public String console()  {
        return "home/console";
    }
}
