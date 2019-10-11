package com.catering.controller;

import com.catering.mapper.MemberMapper_cy;
import com.catering.pojo.Indent;
import com.catering.pojo.Memu;
import com.catering.pojo.MerchantFeature;
import com.catering.pojo.MerchantProfile;
import com.catering.service.MemberService_cy;
import com.catering.service.ReservationService_xt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ReservationConroller_xt {

    @Resource
    ReservationService_xt reservationService_xt;

    @Resource
    MemberService_cy memberService_cy;

    @RequestMapping("/xxx")
    public String confirmOrder(){
        return "confirm_order";
    }
    @RequestMapping("/findMerchand")
    public String findMerchand (Model model){
        int merchantId =5;
        MerchantProfile merchantPro = reservationService_xt.findMerchantProById(merchantId);
        System.out.println("merchantPro = " + merchantPro);
        List<Memu> allMemu = reservationService_xt.findAllMemuById(merchantId);
        System.out.println("allMemu = " + allMemu);
        model.addAttribute("merchantPro",merchantPro);
        model.addAttribute("allMemu",allMemu);
        // 创建一个订单
        Indent indent = new Indent();
        int i = reservationService_xt.addIndent(indent);
        Integer indentId = indent.getId();
        model.addAttribute("indentId",indentId);
        return "cart";
    }

    @ResponseBody
    @RequestMapping("/addIndexMenu")
    public Memu addIndexMenu(int id,int indentId){
        Map<String ,Integer> map = new HashMap<>();
        map.put("indentId",indentId);
        map.put("memuId",id);
        int i = reservationService_xt.addIndentMemu(map);
        System.out.println(" 添加菜单 订单表结果 i = " + i);
        Memu memu = reservationService_xt.findMemuById(id);
        System.out.println("memu = " + memu);
        return memu;
    }

    //生成订单
    @RequestMapping("/addIndent")
    public String addIndent(float count,int merchantId,int memberId,Model model,int indentId){
        System.out.println("count = " + count+" "+memberId+" "+merchantId+"订单id号"+indentId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = dateFormat.format(new Date());
        Indent indent = reservationService_xt.findIndentById(indentId);
        indent.setPrice(count);
        indent.setMerchantId(merchantId);
        indent.setMemberId(memberId);
        indent.setOrdertime(createTime);
        float ding = (float) (count*0.1);
        indent.setDingprice(ding);

        int i = reservationService_xt.addIndent(indent);
        System.out.println(" 添加结果i = " + i);
        // 向前台传出订单详情；
        model.addAttribute("indent",indent);
        //  根据id获取到所拥有的的菜
        List<Memu> indentAllMenuById2 = reservationService_xt.findIndentAllMenuById2(indentId);
        model.addAttribute("allMemu",indentAllMenuById2);
        // 根据id获取这店家的信息
        MerchantProfile merchantPro = reservationService_xt.findMerchantProById(merchantId);
        model.addAttribute("merchantPro",merchantPro);
        // 获取这家店的图片
        MerchantFeature merchantFeaByIdXt = memberService_cy.findMerchantFeaByIdXt(merchantId);
        model.addAttribute("merchantFea",merchantFeaByIdXt);
        return "confirm_order";
    }

}
