package com.netease.zzw.shopping.config;

import com.netease.zzw.shopping.model.Role;
import com.netease.zzw.shopping.model.User;
import com.netease.zzw.shopping.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        String userName = super.getAvailablePrincipal(principalCollection).toString();
        User user = userService.findUserByUserName(userName);
        if(user != null) {
            List<Role> roleList = userService.getUserRole(user.getId());

            if(!roleList.isEmpty()) {
                for(Role role : roleList) {
                    authorizationInfo.addRole(role.getRoleName());
                }
            }
        }
        return authorizationInfo;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();

        User user = userService.findUserByUserName(userName);
        if(user != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user.getUserName(),
                    user.getPassword(),
                    getName()
            );
            return authenticationInfo;
        }
        return null;
    }
}
