package com.catering.controller;

import com.catering.service.MemberService_cy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController_cy {
    @Autowired
    private MemberService_cy memberService_cy;
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    /**
     * 查询标签
     * @return
     */
    @RequestMapping("/findTag")
    @ResponseBody
    public List<String> findTag(){
        List<String> tag = memberService_cy.findTag();
        System.out.println("tag = " + tag);
        return tag;
    }
}
