package com.zty.controller;

import com.zty.domain.ResponseResult;
import com.zty.domain.User;
import com.zty.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @ClassName: com.zty.controller.LoginController.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-25 17:30
 * @Description: 登录
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }

    @RequestMapping("/user/loginOut")
    public ResponseResult loginOut(){
        return loginService.loginOut();
    }
}
