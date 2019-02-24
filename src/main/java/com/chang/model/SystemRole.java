package com.chang.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * description: 后台角色
 * effect: 一个角色对应多种权限
 * author: Chang__
 * createtime: 2018/10/19
 */
@Entity
@Table(name = "system_role")
public class SystemRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String label;
    private Timestamp createdDt;
    private Timestamp updatedDt;

    @OneToOne
    @JoinColumn(name = "created_by")
    @NotFound(action = NotFoundAction.IGNORE)
    private SystemUser createdBy;
    @OneToOne
    @JoinColumn(name = "updated_by")
    @NotFound(action = NotFoundAction.IGNORE)
    private SystemUser updatedBy;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<SystemResource> resources;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<SystemMenu> menus;
    @ManyToMany
    @JoinTable(name = "system_user_role_ref", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<SystemUser> users;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Timestamp getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Timestamp createdDt) {
        this.createdDt = createdDt;
    }

    public Timestamp getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Timestamp updatedDt) {
        this.updatedDt = updatedDt;
    }

    public SystemUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(SystemUser createdBy) {
        this.createdBy = createdBy;
    }

    public SystemUser getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(SystemUser updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Set<SystemResource> getResources() {
        return resources;
    }

    public void setResources(Set<SystemResource> resources) {
        this.resources = resources;
    }

    public Set<SystemMenu> getMenus() {
        return menus;
    }

    public void setMenus(Set<SystemMenu> menus) {
        this.menus = menus;
    }

    public Set<SystemUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SystemUser> users) {
        this.users = users;
    }
}
