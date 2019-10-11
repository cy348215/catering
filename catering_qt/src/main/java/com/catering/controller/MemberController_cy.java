package com.catering.controller;

import com.catering.pojo.Memu;
import com.catering.pojo.MerchantFeature;
import com.catering.pojo.Tag;
import com.catering.service.MemberService_cy;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController_cy {
    @Autowired
    private MemberService_cy memberService_cy;

    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        request.getSession().invalidate();//清除session
        request.getSession().setAttribute("islogin",false);
        return "index";
    }
    @RequestMapping("index1")
    public String index1(HttpServletRequest request) {
        return "index";
    }
    @RequestMapping("/active1")
    public String active1() {
        return "active1";
    }

    @RequestMapping("map1")
    public String map1() {
        return "map1";
    }
    @RequestMapping("map2")
    public String map2() {
        return "map2";
    }

    @RequestMapping("mapPosition")
    public String mapPosition() {
        return "mapPosition";
    }
    @RequestMapping("marchant_cy")
    public String marchant_cy(HttpServletRequest request){
        request.getSession().invalidate();//清除session
        request.getSession().setAttribute("islogin",false);
        return "marchant_cy";
    }

    /**
     * 查询标签
     *
     * @return
     */
    @RequestMapping("/findTag")
    @ResponseBody
    public List<String> findTag() {
        List<String> tag = memberService_cy.findTag();
        System.out.println("tag = " + tag);
        return tag;
    }

    /**
     * 通过标签查询店铺
     *
     * @param tag
     * @param model
     * @return
     */
    @RequestMapping("/searchTag")
    public String searchTag(String tag, Model model) {
        int tagId = memberService_cy.searchTagId(tag);
        List<Integer> list = memberService_cy.searchMerId(tagId);
        List<String> mer = memberService_cy.searchMer(list);
        List<String> tag1 = memberService_cy.findTag1();
        model.addAttribute("tag1",tag1);
        model.addAttribute("mer", mer);
        System.out.println(mer);
        List<String> city = memberService_cy.findCity();
        model.addAttribute("city",city);
        return "active";
    }

    /**
     * 查出所有店铺
     *
     * @return
     */

    @RequestMapping("/searchTag1")
    public String searchTag1(Model model) {
        List<String> mer = memberService_cy.searchTag1();
        model.addAttribute("mer", mer);
        List<String> tag1 = memberService_cy.findTag1();
        model.addAttribute("tag1",tag1);
        List<String> city = memberService_cy.findCity();
        model.addAttribute("city",city);
        return "active";
    }
    /**
     *查询店铺图片
     */
    @RequestMapping("findImg")
    @ResponseBody
    public List<String> findImg(){
        List<String> img1 = memberService_cy.findImg1();
        List<String> img2 = memberService_cy.findImg2();
        List<String> img3 = memberService_cy.findImg3();
        List<String> img=new ArrayList<>();
        img.addAll(img1);
        img.addAll(img2);
        img.addAll(img3);
        System.out.println("img = " + img);
        return img;
    }

    /**
     * 查出所有地点
     * @return
     */
    @RequestMapping("findCity")
    @ResponseBody
    public List<String> findCity(){
        List<String> city1 = memberService_cy.findCity1();
        return city1;
    }
    @RequestMapping("findShop")
    public String findShop(String img1,String img2,String img3,Model model){
        if(img1!=null){
            int i = memberService_cy.searchInt1(img1);
            List<String> strings = memberService_cy.searchMer1(i);
            System.out.println("strings = " + strings);
            List<Memu> dish = memberService_cy.findDish(i);
            model.addAttribute("dish",dish);
            model.addAttribute("strings",strings);
        }else if(img2!=null){
            int i = memberService_cy.searchInt2(img2);
            List<String> strings = memberService_cy.searchMer1(i);
            System.out.println("strings = " + strings);
            List<Memu> dish = memberService_cy.findDish(i);
            model.addAttribute("dish",dish);
            model.addAttribute("strings",strings);
        }else if(img3!=null){
            int i = memberService_cy.searchInt3(img3);
            List<String> strings = memberService_cy.searchMer1(i);
            System.out.println("strings = " + strings);
            List<Memu> dish = memberService_cy.findDish(i);
            model.addAttribute("dish",dish);
            model.addAttribute("strings",strings);
        }
        return "marchant_cy";
    }
}
