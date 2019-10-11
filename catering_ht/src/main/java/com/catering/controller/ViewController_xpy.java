package com.catering.controller;

import com.catering.service.QueryAllCountService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController_xpy {
    @Autowired
    private QueryAllCountService_xpy countService;
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
    public String home(Model model){
        int indCount = countService.findIndCount();
        int memCount = countService.findMemCount();
        int memuCount = countService.findMemuCount();
        int merCount = countService.findMerCount();
        model.addAttribute("indCount",indCount);
        model.addAttribute("memCount",memCount);
        model.addAttribute("memuCount",memuCount);
        model.addAttribute("merCount",merCount);
        return "home";
    }
}
