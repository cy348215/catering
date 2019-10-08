package com.catering.controller;

import com.catering.pojo.*;
import com.catering.service.*;
import com.catering.utils.MailUtils;
import com.catering.utils.SimpleMD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class regController_xpy {
    @Autowired
    private StoreTypeService_xpy storeTypeService;
    @Autowired
    private CityService_xpy cityService;
    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private MerchantProfileService_xpy merchantProfileService;
    @Autowired
    private MerchantService_xpy merchantService;


    @RequestMapping("/register")
    public String reg(){
        return "register";
    }
    @ResponseBody
    @RequestMapping("/getCityId")
    public int getCityId(String name){
        int id = cityService.getCityId(name);
        return id;
    }
    @ResponseBody
    @RequestMapping("/getCity")
    public List<City> getcity(){
        List<City> all = cityService.findAll();
        return all;
    }

    /**
     * 发送邮箱验证码
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendCode")
    public String sendCode(String email){
        String code = mailUtils.sendCode(email, "您的注册验证码为：", "注册验证码");
        System.out.println(code);
        return code;
    }
    /**
     * 注册店铺
     * @param storename
     * @param storetype
     * @param storemaster
     * @param storemember
     * @param phone
     * @param storesheng
     * @param storeshi
     * @param address
     * @param email
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/savestore")
    public boolean savestore(String storename,String storetype,String storemaster,String storemember,
                             String phone,String storesheng,String storeshi,String address,
                             String email,String password,String memberid){
        System.out.println("hhhhhhh");
        Merchant merchant = new Merchant();
        merchant.setUsername(phone+"");
        merchant.setEmail(email);
        merchant.setPassword(SimpleMD5Utils.getPassword(password));
        merchant.setIsLogin(0);
        boolean b = false;
        if (merchantService.saveMerchant(merchant) > 0) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String regTime = dateFormat.format(new Date());
            MerchantProfile merchantProfile = new MerchantProfile();
            merchantProfile.setMerchantId(merchantService.findMerchant(phone+""));
            merchantProfile.setMerchantName(storename);
            merchantProfile.setMerchantPrincipal(storemaster);
            merchantProfile.setMerchantNumber(storemember);
            merchantProfile.setMerchartEmail(email);
            merchantProfile.setPhone(phone);
            merchantProfile.setCreatetime(regTime);
            merchantProfile.setLevel("1");
            merchantProfile.setPoint(0);
            merchantProfile.setCommendCount(0);
            merchantProfile.setCollectCount(0);
            merchantProfile.setHeat(0);
            merchantProfile.setType(storeTypeService.findByName(storetype));
            merchantProfile.setMerchantAddress(address);
            merchantProfile.setCountryId(0);
            merchantProfile.setProvinceId(cityService.getCityId(storesheng));
            merchantProfile.setCityId(cityService.getCityId(storeshi));
            merchantProfile.setMemberid(memberid);
            b = merchantProfileService.saveMerchant(merchantProfile);
        }
        System.out.println(b);
        return b;
    }
    /**
     * 查询所有的标签
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTag")
    public List<StoreType> getTag(){
        List<StoreType> all = storeTypeService.findAll();
        return all;
    }
    /**
     * 检查邮箱是否重复
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkemail")
    public boolean checkstoreemail(String email){
        boolean bool = merchantProfileService.checkname(email);
        System.out.println("checkemail"+bool);
        return bool;
    }
    /**
     * 检查手机号是否重复
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkphone")
    public boolean checkphone(String phone){
        boolean bool = merchantProfileService.checkname(phone);
        System.out.println("checkphone"+bool);
        return bool;
    }
    /**
     * 查询营业执照编号是否重复
     * @param storemember
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkstoremember")
    public boolean checkstoremember(String storemember){
        boolean bool = merchantProfileService.checkmember(storemember);
        System.out.println("checkstoremember"+bool);
        return bool;
    }
    /**
     * 查询店铺名称是否重复
     * @param storename
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkstorename")
    public boolean checkstorename(String storename){
        boolean bool = merchantProfileService.checkname(storename);
        System.out.println("checkstorename"+bool);
        return bool;
    }
}
