package com.netease.zzw.shopping.dto;

import java.io.Serializable;

public class UserRoleDto implements Serializable {
    private String userName;
    private String roleName;
    private String displayRoleName;

    public UserRoleDto() {
    }

    public UserRoleDto(String userName, String roleName, String displayRoleName) {
        this.userName = userName;
        this.roleName = roleName;
        this.displayRoleName = displayRoleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDisplayRoleName() {
        return displayRoleName;
    }

    public void setDisplayRoleName(String displayRoleName) {
        this.displayRoleName = displayRoleName;
    }
}
