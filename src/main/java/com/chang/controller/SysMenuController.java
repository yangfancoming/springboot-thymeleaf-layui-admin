package com.chang.controller;

import com.chang.model.SystemMenu;
import com.chang.service.SysMenuService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by chang .
 * Date: 2019/2/4
 * Time: 17:38
 * Description: To change this TemplateController use File | Settings | File Templates.
 */
@Controller
public class SysMenuController {

    private final Logger logger = LoggerFactory.getLogger(SysMenuController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private SysMenuService menuService;

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

    /**
     * 跳转至菜单页面
     *
     * @param model 页面Model
     * @return {String} 系统菜单管理页面
     * @throws Exception
     */
    @GetMapping(value = "/sysmenu")
    public String findAllSysMenu(Model model) throws Exception {
        List<SystemMenu> menus = menuService.findAllSysMenu();
        model.addAttribute("menus", menus);

        return "/system/menu/sysmenu_list";
    }
}
