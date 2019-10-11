package com.catering.controller;

import com.catering.mapper.MemberMapperXt;
import com.catering.pojo.Member;
import com.catering.service.MemberServiceXt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.RandomValidateCodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

@Controller
public class MemberController_xt {
    @Autowired
    private MemberServiceXt memberServiceXt;

    @RequestMapping ("/login")
    private String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        try {
            Member member = (Member) session.getAttribute("member");
            System.out.println("退出登录的member = " + member);
            Integer state = 1;
            Integer id = member.getId();
            Map<String ,Integer> map = new HashMap<>();
            map.put("id",id);
            map.put("state",state);
            int i = memberServiceXt.updataMemberStateById(map);
            Subject subject = SecurityUtils.getSubject();
            subject.logout();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping ("/reg")
    private String reg(){
        return "reg";
    }
    @RequestMapping("/memberLogin")
    public String memberLogin(String username,String password,String checkcode,HttpServletRequest request,HttpSession session){
        Member member = memberServiceXt.findMember(username, password);
        String code =(String) session.getAttribute("number");


        if (member != null){
            System.out.println("密码账户正确");
            Integer id = member.getId();
            memberServiceXt.findMemberByName(username);
            Integer count = member.getState();

            if(!code.equalsIgnoreCase(checkcode)){
                count=4;
            }
            if (count == 1){
                System.out.println("账户启用");
                int ids = memberServiceXt.findMemberIdByUsername(username);
                member.setId(ids);
                request.getSession().setAttribute("member",member);
                System.out.println("member = " + member);
                Map<String ,Integer> map = new HashMap<>();
                int state = 3;
                map.put("id",id);
                map.put("state",state);

                int i = memberServiceXt.updataMemberStateById(map);
                System.out.println("i = " + i);
                return "redirect:index";
            }else if (count == 2){
                System.out.println("此账户已被禁用");
                return "login";

            } else if (count == 3){
                System.out.println("此账户已登录");
                return "login";
            } else {
                System.out.println("验证码出错");
                return "login";
            }

        }else {
            return "login";
        }



    }
    // 查询是否登录
    @ResponseBody
    @RequestMapping("/state")
    public int state(String username,String password,String checkcode,
                     HttpServletRequest request,HttpSession session){

        Member member = memberServiceXt.findMember(username, password);
        Integer state = member.getState();
        System.out.println(checkcode);
        String code =(String) session.getAttribute("number");
        if(!code.equalsIgnoreCase(checkcode)){
            state=4;
        }
        return state;
    }
    //
    /**
     * 登录验证码
     * @param response
     * @param session
     * @throws IOException
     */
    @GetMapping("/createImage")
    public void createImage(HttpServletResponse response, HttpSession session) throws IOException {
        int width=80,height=30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        g.fillRect(0, 0, width, height);
        //干扰线
        for (int i = 0; i < 10; i++) {
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
        }
        //获取生成的验证码
        String code = getNumber();
        //绑定验证码
        session.setAttribute("number", code);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.drawString(code, 5, 25);
        //设置消息头
        response.setContentType("image/jpeg");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "jpeg", os);
    }
    public String getNumber(){
        String str="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        for(int i= 0;i<4;i++){
            int index = (int)(Math.random()*str.length());
            code+=str.charAt(index);
        }
        System.out.println("code = " + code);
        return code;
    }
}
