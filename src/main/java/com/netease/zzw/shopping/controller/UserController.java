package com.netease.zzw.shopping.controller;

import com.netease.zzw.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login() {
        // TODO 判断是否登录，是则跳转到主页面，否则登录
        return "/user/login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String toLogin() {

        return "/user/login";
    }
}
