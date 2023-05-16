package com.vincent.controller;


import com.vincent.entity.UserLogin;
import com.vincent.service.IUserLoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author vincent
 */
@RestController
@RequestMapping("/user-login")
public class UserLoginController {


    @Resource
    private IUserLoginService userLoginService;

    @GetMapping("/hello")
    public UserLogin hello(){
        return userLoginService.getById("1");
    }
}
