package com.netease.zzw.shopping.service;

import com.netease.zzw.shopping.model.User;

import java.util.List;

public interface UserService {
    User findUserByUserName(String userName);

    List<User> getAllUser();
}
