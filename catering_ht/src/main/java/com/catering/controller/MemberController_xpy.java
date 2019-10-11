package com.catering.controller;

import com.catering.service.MemberProService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController_xpy {
    @Autowired
    private MemberProService_xpy memberProService;
    @RequestMapping("/member_list")
    public String memberList(Model model){
        //memberProService.findAllByState()
        return "member_list";
    }
}
