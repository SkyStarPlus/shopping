package com.netease.zzw.shopping.service;

import com.netease.zzw.shopping.dao.RoleDao;
import com.netease.zzw.shopping.dao.UserDao;
import com.netease.zzw.shopping.dao.UserRoleDao;
import com.netease.zzw.shopping.model.Role;
import com.netease.zzw.shopping.model.User;
import com.netease.zzw.shopping.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public User findUserByUserName(String userName) {
        User user = userDao.findByUserName(userName);
        return user;
    }

    @Override
    public List<Role> getUserRole(long userId) {
        List<UserRole> userRoleList = userRoleDao.findByUserId(userId);
        List<Long> roleIdList = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            roleIdList.add(userRole.getRoleId());
        }
        if(!roleIdList.isEmpty()) {
            List<Role> roleList = roleDao.getRoleByIds(roleIdList);
            return roleList;
        }
        return new ArrayList<Role>();
    }
}
