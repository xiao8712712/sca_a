package com.xiao.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {

    @RequestMapping("/login")
    public String login(String username,String password) {
        return "login";
    }
}
