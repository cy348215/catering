package com.catering.controller;

import com.catering.pojo.Tag;
import com.catering.service.TagService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TagController_xpy {
    @Autowired
    private TagService_xpy tagService;
    @RequestMapping("/tag_list")
    public String tagList(Model model){
        List<Tag> all = tagService.findAll();
        return "tag_list";
    }
}
