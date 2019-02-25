package com.chang.controller;

import com.chang.model.SystemMenu;
import com.chang.param.SysMenuDTO;
import com.chang.param.SysMenuQuery;
import com.chang.service.SysMenuService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
     * 跳转至系统菜单管理页
     *
     * @return
     */
    @GetMapping(value = "/sysmenu/go_sysmenu_list")
    public String goSysMenuList() {
        return "/system/menu/sysmenu_list";
    }

    /**
     * 加载系统菜单列表
     *
     * 注: 数据无需做分页处理, 将所有数据显示在table中
     *
     * @param query 查询参数
     * @return {List} 系统菜单数据
     */
    @GetMapping(value = "/sysmenu")
    @ResponseBody
    public List<SystemMenu> findAllSysMenu(SysMenuQuery query) {
        try {
            return menuService.findAllSysMenu(query);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 跳转至添加一级菜单页面
     *
     * @return 添加一级菜单
     */
    @GetMapping(value = "/sysmenu/parent_save")
    public String goParentMenuSave() {
        return "/system/menu/sysmenu_parent_save";
    }

    /**
     * 保存一级菜单信息
     *
     * @param sysMenuDTO 菜单参数
     * @return {int} 受影响行数
     */
    @PostMapping(value = "/sysmenu/parent_save")
    @ResponseBody
    public int saveParentMenu(@RequestBody SysMenuDTO sysMenuDTO) {
        try {
            menuService.saveParentSysMenu(sysMenuDTO);
            return 1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return 0;
        }
    }

    /**
     * 跳转至添加二级菜单页面
     *
     * @return {String} 添加二级菜单
     * @throws Exception
     */
    @GetMapping(value = "/sysmenu/sub_save")
    public String goSubMenuSave() throws Exception {
        return "/system/menu/sysmenu_sub_save";
    }

    /**
     * 保存二级菜单信息
     *
     * @param sysMenuDTO 请求参数
     * @return {int} 受影响行数
     */
    @PostMapping(value = "/sysmenu/sub_save")
    @ResponseBody
    public int saveSubMenu(@RequestBody SysMenuDTO sysMenuDTO) {
        try {
            menuService.saveSubSysMenu(sysMenuDTO);
            return 1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return 0;
        }
    }

    /**
     * 跳转至修改页面
     *
     * @param menuId 菜单ID
     * @param model Model对象
     * @return {String} 修改菜单
     * @throws Exception
     */
    @GetMapping(value = "/sysmenu/modify/{menu_id}")
    public String goSysMenuModify(@PathVariable(value = "menu_id") long menuId, Model model) throws Exception {
        SystemMenu sysmenu = menuService.findSysMenu(menuId);
        model.addAttribute("sysmenu", sysmenu);

        return "/sysmenu/menu/sysmenu_modify";
    }
}
