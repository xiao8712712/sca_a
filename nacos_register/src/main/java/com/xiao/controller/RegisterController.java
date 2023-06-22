package com.xiao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class RegisterController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/getInfo")
    public String get(){
        return configInfo;
    }
}
