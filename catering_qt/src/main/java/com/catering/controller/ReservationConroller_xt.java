package com.catering.controller;

import com.catering.pojo.Indent;
import com.catering.pojo.Memu;
import com.catering.pojo.MerchantProfile;
import com.catering.service.ReservationService_xt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ReservationConroller_xt {

    @Resource
    ReservationService_xt reservationService_xt;

    @RequestMapping("/findMerchand")
    public String findMerchand (Model model){
        int merchantId =5;
        MerchantProfile merchantPro = reservationService_xt.findMerchantProById(merchantId);
        System.out.println("merchantPro = " + merchantPro);
        List<Memu> allMemu = reservationService_xt.findAllMemuById(merchantId);
        System.out.println("allMemu = " + allMemu);
        model.addAttribute("merchantPro",merchantPro);
        model.addAttribute("allMemu",allMemu);
        return "cart";
    }

    @ResponseBody
    @RequestMapping("/addIndexMenu")
    public Memu addIndexMenu(int id){
        System.out.println("id = " + id);
        Memu memu = reservationService_xt.findMemuById(id);
        System.out.println("memu = " + memu);
        return memu;
    }

    //生成订单
    @RequestMapping("/addIndent")
    public String addIndent(float count,int merchantId,int memberId,Model model){
        System.out.println("count = " + count+" "+memberId+" "+merchantId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = dateFormat.format(new Date());
        Indent indent = new Indent();
        indent.setPrice(count);
        indent.setMerchantId(merchantId);
        indent.setMemberId(memberId);
        indent.setOrdertime(createTime);
        float ding = (float) (count*0.1);
        indent.setDingprice(ding);
        // 订单号

        System.out.println("indent = " + indent);
        // 生成订单
        reservationService_xt.addIndent(indent);

        //
        return "confirm_order";
    }

}
