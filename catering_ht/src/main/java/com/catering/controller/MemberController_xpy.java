package com.catering.controller;

import com.catering.pojo.Member;
import com.catering.pojo.MemberProfile;
import com.catering.service.MemberProService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MemberController_xpy {
    @Autowired
    private MemberProService_xpy memberProService;
    @RequestMapping("/member_list")
    public String memberList(Model model){
        List<MemberProfile> all = memberProService.findAll();
        model.addAttribute("xx",0);
        model.addAttribute("count",all.size());
        model.addAttribute("member",all);
        return "member_list";
    }

    @RequestMapping("/member_info")
    public String memberInfo(int id,Model model){
        MemberProfile profile = memberProService.findById(id);
        model.addAttribute("mem",profile);
        Member member = memberProService.findMember(id);
        model.addAttribute("mmm",member);
        return "member_info";
    }

    @ResponseBody
    @RequestMapping("/saveMember")
    public int saveMember(String name,String dealname,int sex,String password,
                          String phone,String email,String address){
        Member member = new Member();
        member.setUsername(phone);
        member.setEmail(email);
        member.setPassword(password);
        member.setState(1);
        int i = memberProService.saveMember(member);
        if (i > 0){
            MemberProfile memberProfile = new MemberProfile();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String regTime = dateFormat.format(new Date());
            Integer id = memberProService.findByName(phone).getId();
            memberProfile.setRegisterTime(regTime);
            memberProfile.setId(id);
            memberProfile.setNickname(name);
            memberProfile.setName(dealname);
            memberProfile.setEmail(email);
            memberProfile.setMobile(phone);
            memberProfile.setAddress(address);
            memberProfile.setGender(sex);
            i = memberProService.savePro(memberProfile);
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/delmem")
    public int delmem(int id){
        int i = memberProService.delMember(id);
        if (i > 0){
            i = memberProService.delPro(id);
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/updateState")
    public int updateState(int id,int state){
        Member member = new Member();
        member.setState(state);
        member.setId(id);
        int i = memberProService.updateMemberState(member);
        return i;
    }

    @ResponseBody
    @RequestMapping("/updateMemInfo")
    public int updateMemInfo(String password,String phone,String email,String address,int sex,int id,String nickName){
        System.out.println("start");
        System.out.println("phone"+phone+"====sex"+sex+"====address"+address+"nickname"+nickName);
        Member member = new Member();
        member.setId(id);
        member.setPassword(password);
        int i = memberProService.updateMemberPass(member);
        System.out.println(i);
        if (i > 0){
            MemberProfile memberProfile = new MemberProfile();
            memberProfile.setId(i);
            memberProfile.setEmail(email);
            memberProfile.setAddress(address);
            memberProfile.setMobile(phone);
            memberProfile.setNickname(nickName);
            memberProfile.setGender(sex);
            i = memberProService.updatePro(memberProfile);
        }
        System.out.println("end");
        return i;
    }

    @RequestMapping("/selectMem")
    public String selectMem(String tiao,String time,Model model){
        List<MemberProfile> all = memberProService.query(tiao, time);
        model.addAttribute("xx",0);
        model.addAttribute("count",all.size());
        model.addAttribute("member",all);
        return "member_list";
    }
}
