package com.chang.controller;

import com.chang.model.Template;
import com.chang.param.TemplateDTO;
import com.chang.param.TemplateQuery;
import com.chang.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 案例模板
 * Created by ANdady on 2019/2/12.
 */
@Controller
@RequestMapping(value = "/template")
public class TemplateController {

    private final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    private TemplateService templateService;

    @GetMapping(value = "/go_template_list")
    public String goTemplateList() {
        return "/template/template_list";
    }

    /**
     * 加载template案例数据
     *
     * @param pageNo 页码
     * @param limit 每页的数据量
     * @param query 查询条件
     * @return {Page} 分页数据
     */
    @GetMapping
    @ResponseBody
    public Page<Template> findAllTemplate(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                          @RequestParam(value = "limit", defaultValue = "10") int limit,
                                          TemplateQuery query) {
        Page<Template> page;

        try {
            page = templateService.findAllTemplate(pageNo, limit, query);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            page = null;
        }

        return page;
    }

    /**
     * 跳转至template的新增页面
     *
     * @return {String} 新增页面
     */
    @GetMapping(value = "/save")
    public String goTemplateSave() {
        return "/template/template_save";
    }

    /**
     * 添加template数据
     *
     * @param templateDTO templateDTO对象
     * @return {int} 状态码
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public int saveTemplate(@RequestBody TemplateDTO templateDTO) {
        try {
            templateService.saveTemplate(templateDTO);
            return 0;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return 1;
        }
    }

    /**
     * 跳转至template的更新页面
     *
     * @param templateId templateId
     * @return {String} 编辑页面
     */
    @GetMapping(value = "/modify/{template_id}")
    public String goTemplateModify(@PathVariable(value = "template_id") long templateId) {
        return "/template/template_modify";
    }

    /**
     * 修改template数据
     *
     * @param templateId ID
     * @param template template对象
     * @return {int} 状态码
     */
    @PutMapping(value = "/modify/{template_id}")
    @ResponseBody
    public int modifyTemplate(@PathVariable(value = "template_id") long templateId, @RequestBody Template template) {
        try {
            templateService.modifyTemplate(templateId, template);
            return 0;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return 1;
        }
    }

    /**
     * 删除template数据
     *
     * @param templateId 模板ID
     * @return {int} 状态码
     */
    @DeleteMapping(value = "/delete/{template_id}")
    @ResponseBody
    public int deleteTemplate(@PathVariable(value = "template_id") Long templateId) {
        try {
            templateService.deleteTemplate(templateId);
            return 0;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return 1;
        }
    }
}
