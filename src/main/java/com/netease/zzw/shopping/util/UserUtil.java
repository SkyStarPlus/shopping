package com.netease.zzw.shopping.util;

import com.netease.zzw.shopping.config.UserConst;
import com.netease.zzw.shopping.dto.UserRoleDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class UserUtil {
    public static UserRoleDto getUserRoleDto() {
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()) {
            return new UserRoleDto("", "", "");
        }

        String userName = subject.getPrincipal().toString();
        if(subject.hasRole(UserConst.RoleName.seller.name())) {
            return new UserRoleDto(userName, UserConst.RoleName.seller.name(), "卖家");
        } else if(subject.hasRole(UserConst.RoleName.buyer.name())) {
            return new UserRoleDto(userName, UserConst.RoleName.buyer.name(), "买家");
        } else {
            return new UserRoleDto(userName, "", "");
        }
    }



    public static String getUserName() {
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()) {
            return "";
        }
        return subject.getPrincipal().toString();
    }
}
