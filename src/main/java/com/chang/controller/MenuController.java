package com.chang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/index")
    public String index() {
        return "/index";
    }

    @GetMapping(value = "/menu/console")
    public String console()  {
        return "/home/console";
    }

    @GetMapping(value = "/menu/homepage1")
    public String homepage1() {
        return "/home/homepage1";
    }

    @GetMapping(value = "/menu/homepage2")
    public String homepage2() {
        return "/home/homepage2";
    }
}
