package com.catering.controller;

import com.catering.mapper.MemberProfileMapperLxz;
import com.catering.pojo.Indent;
import com.catering.pojo.MemberProfile;
import com.catering.pojo.Memu;
import com.catering.pojo.MerchantProfile;
import com.catering.service.impl.IndentServiceImplLxz;
import com.catering.service.impl.MemberprofileImpl;
import com.catering.service.impl.MemuServiceImplLxz;
import com.catering.service.impl.TagServiceIMplLxz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LxzOrdManagerController {
    @Autowired
    private MemuServiceImplLxz memuServiceImplLxz;
    @Autowired
    private TagServiceIMplLxz tagServiceIMplLxz;
    @Autowired
    private IndentServiceImplLxz indentServiceImplLxz;
    @Autowired
    private MemberprofileImpl memberprofileImpl;

    //订单列表
    @RequestMapping("/ordlist")
    public String ordList(HttpServletRequest request){
        HttpSession session=request.getSession();
        MerchantProfile user = (MerchantProfile) session.getAttribute("user");
        List<Indent> indents=indentServiceImplLxz.fingAllIndent(user.getMerchantId());
        session.setAttribute("indents",indents);
        for (Indent indent:indents) {
            int mId=indent.getMemberId();
            MemberProfile memberProfiles=memberprofileImpl.findMemberProfileById(mId);
            session.setAttribute("m",memberProfiles);
        }
        return "ordlist";
    }
    //订单详情
    @RequestMapping("/order_detail")
    public String order_detail(Model model,int id,int did,HttpServletRequest request){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        List<Memu> memuList=memuServiceImplLxz.findMemuByDid(did);
        Indent indent=indentServiceImplLxz.findIndentByDid(did,user.getMerchantId());
        Double sumPrice=memuServiceImplLxz.sumPrice(did);
        model.addAttribute("indent",indent);
        model.addAttribute("sumPrice",sumPrice);
        model.addAttribute("memuList",memuList);
        return "order_detail";
    }
    //订单审核
    @RequestMapping("/ordcheck")
    public String ordCheck(){
        return "ordCheck";
    }
    //取消订单
    @RequestMapping("/drawback")
    public String drawBack(){
        return "drawBack";
    }
    //添加菜品
    @RequestMapping("/addmenu")
    public String addMenu(){
        return "addmenu";
    }
    //添加菜单结果
    @ResponseBody
    @RequestMapping("/resAddMenu")
    public boolean addMenuRes(String dishId,int type,Double dishPrice,String imgsrc,String cuisine){
        String str="image1/"+imgsrc+".jpg";
        boolean bool;
        Memu menu=new Memu();
        menu.setDishId(dishId);
        menu.setType(type);
        menu.setDishPrice(dishPrice);
        menu.setImg1(str);
        menu.setLabel(cuisine);
        bool=memuServiceImplLxz.addMemu(menu);
        return bool;
    }
    //查询所有菜系
    @ResponseBody
    @RequestMapping("/findCuisine")
    public List<String> findCuisine(){
        return tagServiceIMplLxz.findCuisine();
    }

    //查询菜单
    @RequestMapping("/memulist")
    public String memulistLxz(@RequestParam(required = false,defaultValue = "1")int page
                              ,@RequestParam(required = false,defaultValue = "6")int rows
                              ,Model model){
        int maxPage=memuServiceImplLxz.calcMaxMemu(rows);
        if (page<1){
            page=maxPage;
        }if (page>maxPage){
            page=1;
        }
        List<Memu> memus=memuServiceImplLxz.findAllMemu( page,rows);
        model.addAttribute("maxPage",maxPage);
        model.addAttribute("currentPage",page);
        model.addAttribute("memus",memus);
        return "memulistLxz";
    }
    //审核订单
    @ResponseBody
    @RequestMapping("/review")
    public boolean reView(int id){
        boolean bool=indentServiceImplLxz.revIndent(id);
        return bool;
    }
    //菜单回收站
    @RequestMapping("/recycle")
    public String recycle(Model model){
        List<Memu> memus=memuServiceImplLxz.findRcycle();
        model.addAttribute("memus1",memus);
        return "recycle";
    }
    //删除菜单
    @ResponseBody
    @RequestMapping("/deleteMemu")
    public boolean deleteMemu(int id){
        boolean bool=memuServiceImplLxz.delMemu(id);
        return bool;
    }
}

