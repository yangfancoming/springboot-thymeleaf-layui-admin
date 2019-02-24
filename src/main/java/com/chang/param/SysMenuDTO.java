package com.chang.param;

import com.chang.model.SystemMenu;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ANdady on 2019/2/23.
 */
public class SysMenuDTO {

    private String name;
    private String url;
    private int sortNo;
    private String icon;

    private Long parentId;
    private List<Long> roleIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public SystemMenu getSysMenuInstance() {
        SystemMenu menu = new SystemMenu();
        menu.setName(this.getName());
        menu.setUrl(this.getUrl());
        menu.setSortNo(this.getSortNo());
        menu.setIcon(this.getIcon());
        menu.setCreateDt(new Timestamp(System.currentTimeMillis()));

        return menu;
    }
}
