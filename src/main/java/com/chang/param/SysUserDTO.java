package com.chang.param;

import com.chang.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EDZ on 2019/2/25.
 */
public class SysUserDTO {

    private String account;
    private String password;
    private String phone;
    private String nickname;

    private List<Long> roleIds = new ArrayList<>();

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
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

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public SystemUser getSysUserInstance() {
        SystemUser user = new SystemUser();
        user.setAccount(this.getAccount());
        user.setPassword(this.getPassword());
        user.setNickname(this.getNickname());
        user.setPhone(this.getPhone());

        return user;
    }
}
