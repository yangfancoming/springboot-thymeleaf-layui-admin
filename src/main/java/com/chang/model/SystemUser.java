package com.chang.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * description: 后台用户
 * effect: 一个用户对应一个角色
 * author: Chang__
 * createtime: 2018/10/19
 */
@Entity
@Table(name = "system_user")
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String account;
    private String password;
    private String phone;
    private String nickname;
    private String status;
    private Timestamp createdDt;
    private Timestamp updatedDt;
    private Timestamp lastLoginDt;

    @OneToOne
    @JoinColumn(name = "created_by")
    @NotFound(action = NotFoundAction.IGNORE)
    private SystemUser createdBy;
    @OneToOne
    @JoinColumn(name = "updated_by")
    @NotFound(action = NotFoundAction.IGNORE)
    private SystemUser updatedBy;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<SystemRole> roles = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Timestamp getLastLoginDt() {
        return lastLoginDt;
    }

    public void setLastLoginDt(Timestamp lastLoginDt) {
        this.lastLoginDt = lastLoginDt;
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

    public String getPassword() {
        return password;
    }

    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        if (CollectionUtils.isEmpty(roles)) {
//            return null;
//        }
//
//        for (SystemRole role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getLabel()));
//        }
//
//        return authorities;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.account;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
