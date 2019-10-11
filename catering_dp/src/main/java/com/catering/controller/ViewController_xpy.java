package com.catering.controller;

import com.catering.pojo.Indent;
import com.catering.pojo.MerchantFeature;
import com.catering.pojo.MerchantProfile;
import com.catering.service.IndentService_xpy;
import com.catering.service.MerchantFeatureService_xpy;
import com.catering.service.MerchantService_xpy;
import com.catering.service.impl.MenuServiceImpl_xpy;
import com.catering.service.impl.MerchantFeatureServiceImpl_xpy;
import com.catering.utils.SimpleMD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ViewController_xpy {
    @Autowired
    private IndentService_xpy indentService;
    @Autowired
    private MenuServiceImpl_xpy menuServiceImpl;
    @Autowired
    private MerchantService_xpy merchantService;

    @RequestMapping("/revise_password")
    public String revisePassword(){
        return "revise_password";
    }
    @ResponseBody
    @RequestMapping("/updateInfo")
    public int updateInfo(String password,HttpServletRequest request){
        String password1 = SimpleMD5Utils.getPassword(password);
        System.out.println(password);
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        System.out.println(user);
        int i = merchantService.updatePassword(user.getMerchantId(), password1);
        System.out.println(i);
        return i;
    }
    @RequestMapping("/storeInfo")
    public String StoreInfo(Model model, HttpServletRequest request){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        int id = user.getMerchantId();
        //总订单数量
        int count = indentService.findCount(id);
        model.addAttribute("count",count);
        //已完成订单数量
        int endCount = indentService.findCountByState(id, 2);
        model.addAttribute("endCount",endCount);
        //未完成
        int startCount = indentService.findCountByState(id, 1);
        model.addAttribute("startCount",startCount);
        //总金额
        Float price = indentService.findPriceByState(id, 2);
        model.addAttribute("price",price);
        //今日
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Time = dateFormat.format(new Date());
        List<Indent> list = indentService.findByOrderTime(id,Time);
        int cuendCount = 0;
        int custartCount = 0;
        float cuprice = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getState() == 1){
                custartCount++;
            }
            if (list.get(i).getState() == 2){
                cuendCount++;
                cuprice += list.get(i).getPrice();
            }
        }
        model.addAttribute("cuCount",list.size());
        model.addAttribute("cuendCount",cuendCount);
        model.addAttribute("custartCount",custartCount);
        model.addAttribute("cuprice",cuprice);
        //商品数量
        int menucount = menuServiceImpl.findCount(id);
        model.addAttribute("menuCount",menucount);
        return "storeInfo";
    }
}
