package com.catering.controller;

import com.catering.pojo.Tag;
import com.catering.service.MemberService_cy;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    @RequestMapping("/searchTag")
    public String searchTag(String tag, Model model){
        int tagId = memberService_cy.searchTagId(tag);
        List<Integer> list = memberService_cy.searchMerId(tagId);
        List<String> mer= memberService_cy.searchMer(list);
        model.addAttribute("mer",mer);
        return "active";
    }
}
