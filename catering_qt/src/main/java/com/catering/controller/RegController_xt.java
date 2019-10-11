package com.catering.controller;

import com.catering.pojo.Member;
import com.catering.pojo.MemberProfile;
import com.catering.service.MemberServiceXt;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class RegController_xt {
    @Autowired
    private MemberServiceXt memberServiceXt;

//    注册人员信息
    @ResponseBody
    @RequestMapping("/regMember")
    public int regMember(String username,String password ,String email,HttpServletRequest request) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = dateFormat.format(new Date());
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setEmail(email);
        member.setLastlogintime(createTime);

        MemberProfile memberProfile = new MemberProfile();
        memberProfile.setNickname(username);
        memberProfile.setEmail(email);
        memberProfile.setRegisterTime(createTime);
        int count = 0;
        boolean b1 = memberServiceXt.findMemberByName(username);
        System.out.println("b1 = " + b1);
        if (b1 == true){
            count = 1; // 在此期间被抢了
            return count;
        } else {
            boolean b2 = findMemberByEmail(email);
            if (b2 == true){
                count = 2; // 在此期间被抢了
                return count;
            } else {
                // 注册人员信息
                member.setState(3);
                boolean boo = memberServiceXt.addMember(member);
                int id = memberServiceXt.findMemberIdByUsername(username);
                memberProfile.setId(id);
                member.setId(id);
                System.out.println("member = " + member);
                boolean boo2 = memberServiceXt.addMemberPro(memberProfile);
                if (boo == true && boo2 == true){
                    request.getSession().invalidate();//清除session
                    request.getSession().setAttribute("member",member);
                    request.getSession().setAttribute("islogin",true);
                    count = 3; // 成功了
                    return count;
                } else {
                    count = 4; // 失败了
                    return count;
                }

            }
        }


//        返回前传入session  user
    }

//    判断用户名是否已经被使用
    @ResponseBody
    @RequestMapping("/findMemberByUsername")
    public boolean findMemberByUsername(String username){
        boolean b = memberServiceXt.findMemberByName(username);
        return b;
    }

    //    判断邮箱是否已经被使用
    @ResponseBody
    @RequestMapping("/findMemberByEmail")
    public boolean findMemberByEmail(String email){
        boolean b = memberServiceXt.findMemberByEmail(email);
        return b;
    }

    @ResponseBody
    @RequestMapping("/sendEmailCode")
    public boolean showapply(String email) throws Exception{
        System.out.println("email = " + email);
        HtmlEmail htmlEmail = new HtmlEmail();
        htmlEmail.setHostName("smtp.qq.com");
        htmlEmail.setAuthentication("1611691236@qq.com","pjhoxjiyoquifcgg");
//        设置文本编辑格式
        htmlEmail.setCharset("UTF-8");
//        生成6位随机验证码
        Random random = new Random();
        int yzm = 0;
        String s = "";
        for (int i = 0 ;i<6;i++){
            yzm = random.nextInt(10);
            s+= yzm;
        }
        System.out.println("s = " + s);
        if (s!=null){
//            设置发件人的邮箱地址和昵称
            htmlEmail.setFrom("1611691236@qq.com","zz");
//            设置发送邮件的主题
            htmlEmail.setSubject("zz");
//            邮件内容
            htmlEmail.setMsg("您的验证码是："+s);
//            收件人邮箱
            htmlEmail.addTo(email);
//            发送
            htmlEmail.send();
        }
        return true;
    }

}
