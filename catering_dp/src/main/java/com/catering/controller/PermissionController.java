package com.catering.controller;

import com.catering.pojo.StorePermission;
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
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/bar")
    public String bar(){
        return "bar";
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/menu")
    public String menu(){
        return "menu";
    }
    @RequestMapping("/top")
    public String top(){
        return "top";
    }
    @ResponseBody
    @RequestMapping("/permission")
    public List<StorePermission> permissions(){
        List<StorePermission> permissionList = permissionService.findByid(1);
        return permissionList;
    }
}
