package com.catering.controller;

import com.catering.pojo.MerchantFeature;
import com.catering.pojo.MerchantProfile;
import com.catering.service.MerchantFeatureService_xpy;
import com.catering.service.MerchantProfileService_xpy;
import com.catering.service.MerchantService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShopController_xpy {
    @Autowired
    private MerchantProfileService_xpy profileService;
    @Autowired
    private MerchantFeatureService_xpy featureService;
    @Autowired
    private MerchantService_xpy merchantService;

    @RequestMapping("/Shop_list")
    public String ShopList(Model model){
        int ids = merchantService.findids(1);
        List<MerchantProfile> list = profileService.findByisl(1);
        int ll = 0;
        if (list.size()>0){
            ll = 1;
        }
        model.addAttribute("xu",0);
        model.addAttribute("ll",ll);
        model.addAttribute("count",ids);
        model.addAttribute("store",list);
        return "Shop_list";
    }

    @RequestMapping("/findTime")
    public String findTime(String time,Model model){
        System.out.println(time);
        List<MerchantProfile> list = profileService.findTime(time);
        int ll = 0;
        if (list.size()>0){
            ll = 1;
        }
        model.addAttribute("xu",0);
        model.addAttribute("ll",ll);
        model.addAttribute("count",list.size());
        model.addAttribute("store",list);
        return "Shop_list";
    }
    @RequestMapping("/shopping_detailed2")
    public String shoppingDetailed2(int id,Model model){
        MerchantProfile profile = profileService.findById(id);
        model.addAttribute("store",profile);
        MerchantFeature feature = featureService.findById(id);
        model.addAttribute("feature",feature);
        return "shopping_detailed2";
    }
    @RequestMapping("/Shop_Audit")
    public String shopAudit(Model model){
        int ids = merchantService.findids(0);
        List<MerchantProfile> list = profileService.findByisl(0);
        int ll = 0;
        if (list.size()>0){
            ll = 1;
        }
        model.addAttribute("ll",ll);
        model.addAttribute("count",ids);
        model.addAttribute("store",list);
        return "Shops_Audit";
    }
    @ResponseBody
    @RequestMapping("/delMerProfile")
    public int delMerProfile(int id){
        int i = merchantService.delById(id);
        if (i > 0){
            i = profileService.delById(i);
        }
        return i;
    }

    @RequestMapping("/shopping_detailed")
    public String shoppingDetailed(int id,Model model){
        MerchantProfile profile = profileService.findById(id);
        model.addAttribute("store",profile);
        MerchantFeature feature = featureService.findById(id);
        model.addAttribute("feature",feature);
        return "shopping_detailed";
    }

    @ResponseBody
    @RequestMapping("/tongguo")
    public int tongguo(int id){
        System.out.println(id);
        int i = merchantService.updateIs(id, 1);
        System.out.println(i);
        return i;
    }
    @ResponseBody
    @RequestMapping("/saveIstro")
    public int saveIstro(String content){
        int i = 0;
        if (content != null){
            i = 1;
        }
        return i;
    }
}
