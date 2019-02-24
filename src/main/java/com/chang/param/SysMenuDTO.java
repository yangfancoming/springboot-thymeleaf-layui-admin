package com.chang.param;

import com.chang.model.SystemMenu;

import java.util.List;

/**
 * Created by ANdady on 2019/2/23.
 */
public class SysMenuDTO {

    private String name;
    private String url;
    private int sortNo;
    private String icon;
    private boolean isParent = false;

    private long parentId;
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

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
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
//        menu.setParent(this.isParent());

        return menu;
    }
}
