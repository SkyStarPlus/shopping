package com.netease.zzw.shopping.service;

import com.netease.zzw.shopping.dao.UserDao;
import com.netease.zzw.shopping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByUserName(String userName) {
        User user = userDao.findByUserName(userName);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }
}
