package com.catering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController_cy {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}