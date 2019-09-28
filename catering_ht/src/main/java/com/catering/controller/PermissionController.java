package com.catering.controller;

import com.catering.pojo.AdminPermission;
import com.catering.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/admin_info")
    public String bar() {
        return "admin_info";
    }
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @ResponseBody
    @RequestMapping("/permission")
    public List<AdminPermission> permissions(){
        List<AdminPermission> permissionList = permissionService.findByid(1);
        System.out.println(permissionList);
        return permissionList;
    }
}
