package com.catering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LxzOrdManaController {

    //订单列表
    @RequestMapping("/ordlist")
    public String ordList(){
        return "ordlist";
    }
    //订单审核
    @RequestMapping("/ordcheck")
    public String ordCheck(){
        return "ordCheck";
    }
    //取消订单
    @RequestMapping("/drawback")
    public String drawBack(){
        return "drawBack";
    }
    //审核订单
    @RequestMapping("/ordcheck_1")
    public String ordcheck_1(){
        return "ordcheck_1";
    }
}

