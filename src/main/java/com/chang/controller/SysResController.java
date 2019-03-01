package com.chang.controller;

import com.chang.model.SystemResource;
import com.chang.param.SysResDTO;
import com.chang.param.SysResQuery;
import com.chang.service.SysResService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ANdady on 2019/2/23.
 */
@Controller
@RequestMapping(value = "/sysrec")
public class SysResController {

    private final Logger logger = LoggerFactory.getLogger(SysResController.class);

    @Autowired
    private SysResService resService;

    /**
     * 跳转至资源列表页面
     *
     * @return 资源列表
     */
    @GetMapping(value = "/go_sysres_list")
    public String goSysResList() {
        return "/system/resource/sysres_list";
    }

    /**
     * 加载系统资源信息
     *
     * @param pageNo 页码
     * @param limit 每页所显示的记录数
     * @param query 查询参数
     * @return {Page} 分页数据
     */
    @GetMapping
    @ResponseBody
    public Page<SystemResource> findAllSysRes(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                              @RequestParam(value = "limit", defaultValue = "10") int limit,
                                              SysResQuery query) {
        Page<SystemResource> page;
        try {
            page = resService.findAllSysRes(pageNo, limit, query);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            page = null;
        }

        return page;
    }

    @GetMapping(value = "/save")
    public String goSaveResSys() {
        return "/system/resource/sysres_save";
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public int saveResSys(@RequestBody SysResDTO sysResDTO) {
        return 0;
    }

    @GetMapping(value = "/modify/{res_id}")
    public String goModifyResSys(@PathVariable(value = "res_id") Long resId) {
        return "/system/resource/sysres_modify";
    }

    @PutMapping(value = "/modify/{res_id}")
    @ResponseBody
    public int modifyResSys(@PathVariable(value = "res_id") Long resId, @RequestBody SysResDTO sysResDTO) {
        try {
            resService.modifySysRes(resId, sysResDTO);
            return 0;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return 1;
        }
    }

    @DeleteMapping(value = "/delete/{res_id}")
    @ResponseBody
    public int deleteResSys(@PathVariable(value = "res_id") Long resId) {
        try {
            resService.deleteSysRes(resId);
            return 0;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return 1;
        }
    }
}
