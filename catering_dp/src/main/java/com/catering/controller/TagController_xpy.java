package com.catering.controller;

import com.catering.pojo.MerchantProfile;
import com.catering.pojo.Tag;
import com.catering.service.TagService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TagController_xpy {
    @Autowired
    private TagService_xpy tagService;
    @RequestMapping("/tag_list")
    public String tagList(Model model, HttpServletRequest request){
        List<Tag> all = tagService.findAll();
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        List<Tag> allMer = tagService.findAllMer(user.getMerchantId());
        for (Tag t : allMer) {
            for (Tag t1 : all) {
                if (t.getCuisineId() == t1.getCuisineId()){
                    t1.setIsBoolean(1);
                    break;
                }
            }
        }
        model.addAttribute("allTag",all);
        return "tag_list";
    }

    @RequestMapping("/deleteTypeTag")
    public String deleteTypeTag(int tid,HttpServletRequest request){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        int i = tagService.deleteTypeTag(user.getMerchantId(), tid);
        System.out.println("delete"+i);
        return "redirect:tag_list";
    }
    @RequestMapping("/saveTypeTag")
    public String saveTypeTag(int tid,HttpServletRequest request){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        int i = tagService.saveTypeTag(user.getMerchantId(), tid);
        System.out.println("save"+i);
        return "redirect:tag_list";
    }
}
