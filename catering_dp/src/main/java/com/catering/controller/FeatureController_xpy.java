package com.catering.controller;

import com.catering.pojo.MerchantFeature;
import com.catering.pojo.MerchantProfile;
import com.catering.service.MerchantFeatureService_xpy;
import com.catering.service.MerchantProfileService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FeatureController_xpy {
    @Autowired
    private MerchantFeatureService_xpy featureService;
    @Autowired
    private MerchantProfileService_xpy profileService;
    @RequestMapping("/store_detail")
    public String storeDetail(Model model, HttpServletRequest request){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        MerchantFeature feature = featureService.findById(user.getMerchantId());
        request.getSession().setAttribute("feature",feature);
        return "store_detail";
    }
    @ResponseBody
    @RequestMapping("/savefeature")
    public int savefeature(String name, String phone, String email, String intro, HttpServletRequest request){
        System.out.println("begin");
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        int c = 0;
        MerchantProfile profile = new MerchantProfile();
        profile.setMerchantName(name);
        profile.setPhone(phone);
        profile.setMerchartEmail(email);
        boolean b = profileService.saveMerchant(profile);
        System.out.println("boolean"+b);
        MerchantFeature feature1 = (MerchantFeature) request.getSession().getAttribute("feature");
        MerchantFeature feature = new MerchantFeature();
        feature.setIntro(intro);
        if (b){
            if (feature1 == null){
                feature.setMerchantId(user.getMerchantId());
                c = featureService.saveFeature(feature);
            } else {
                c = featureService.saveFeature(feature);
            }
        }
        System.out.println("end");
        return c;
    }
}
