package com.catering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LxzTextController {
    @RequestMapping("/hi")
    public String Hi(){
        return "hi";
    }
}
