package com.chang.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
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

    @ManyToMany
    @JoinTable(name = "system_role_resource_ref", joinColumns = @JoinColumn(name = "resource_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<SystemRole> roles = new HashSet<>();

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

    public Set<SystemRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SystemRole> roles) {
        this.roles = roles;
    }
}
