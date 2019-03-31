package com.netease.zzw.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.netease.zzw.shopping.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login() {
        // TODO 判断是否登录，是则跳转到主页面，否则登录
        return "/user/login";
    }

    @RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
    @ResponseBody
    public String toLogin(@RequestParam(value = "userName") String userName,
                          @RequestParam(value = "password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            JSONObject resultPath = new JSONObject();
            resultPath.put("code", 404);
            return resultPath.toJSONString();
        }


        JSONObject resultPath = new JSONObject();
        resultPath.put("code", 200);
        return resultPath.toJSONString();
    }
}