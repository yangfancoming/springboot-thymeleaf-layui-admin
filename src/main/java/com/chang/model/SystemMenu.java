package com.chang.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * description: 后台菜单栏
 * effect: 后台的菜单栏目
 * author: Chang__
 * createtime: 2018/10/19
 */
@Entity
@Table(name = "system_menu")
public class SystemMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String url;
    private int sortNo;
    private String icon;
    private boolean isParent;
    private boolean isDelete;
    private Timestamp updateTime;

    @OneToOne
    @JoinColumn(name = "updateUserId")
    @NotFound(action = NotFoundAction.IGNORE)
    private SystemUser updateUser;


    @Transient
    private SystemMenu parentNode;
    @ManyToMany
    @JoinTable(name = "system_role_menu_ref", joinColumns = @JoinColumn(name = "menuId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<SystemRole> roles;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId")
    private List<SystemMenu> submenus; //子菜单

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public SystemUser getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(SystemUser updateUser) {
        this.updateUser = updateUser;
    }

    public SystemMenu getParentNode() {
        return parentNode;
    }

    public void setParentNode(SystemMenu parentNode) {
        this.parentNode = parentNode;
    }

    public Set<SystemRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SystemRole> roles) {
        this.roles = roles;
    }

    public List<SystemMenu> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(List<SystemMenu> submenus) {
        this.submenus = submenus;
    }
}
