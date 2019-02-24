package com.chang.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
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
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp lastLoginTime;

    @OneToOne
    @JoinColumn(name = "updateUserId")
    @NotFound(action = NotFoundAction.IGNORE)
    private SystemUser updateUser;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<SystemRole> roles;

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
