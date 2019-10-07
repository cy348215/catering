package com.catering.controller;

import com.catering.mapper.MemberMapperXt;
import com.catering.service.MemberServiceXt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController_xt {
    @Autowired
    MemberServiceXt memberServiceXt;

    @RequestMapping ("/login")
    private String login(){
        return "login";
    }
    @RequestMapping("/memberLogin")
    public String memberLogin(String username,String password){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        boolean b = memberServiceXt.findMember(username, password);
        if (b == true){
            System.out.println("密码账户正确");
        }
        return "login";
    }
}
