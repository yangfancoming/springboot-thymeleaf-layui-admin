package com.chang.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Chang on 2018/11/1.
 */
@Entity
@Table(name = "system_resource")
public class SystemResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String matchUrl;
    private Timestamp updateTime;

    @OneToOne
    @JoinColumn(name = "updateUserId")
    @NotFound(action = NotFoundAction.IGNORE)
    private SystemUser updateUser;

    @ManyToMany
    @JoinTable(name = "system_role_resource_ref", joinColumns = @JoinColumn(name = "resourceId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<SystemRole> roles;

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

    public String getMatchUrl() {
        return matchUrl;
    }

    public void setMatchUrl(String matchUrl) {
        this.matchUrl = matchUrl;
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

    public Set<SystemRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SystemRole> roles) {
        this.roles = roles;
    }
}
