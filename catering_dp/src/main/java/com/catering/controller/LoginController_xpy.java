package com.catering.controller;

import com.catering.pojo.Merchant;
import com.catering.pojo.MerchantProfile;
import com.catering.service.MerchantProfileService_xpy;
import com.catering.service.MerchantService_xpy;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@Controller
public class LoginController_xpy {
    @Autowired
    private MerchantService_xpy merchantService;
    @Autowired
    private MerchantProfileService_xpy merchantProfileService;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/loginCode")
    public int loginCode(String code,String username,String password, HttpServletRequest request){
        String number = (String) request.getSession().getAttribute("number");
        System.out.println(number);
        if (code.equalsIgnoreCase(number)){
            Merchant merchant = merchantService.findMerchantByName(username);
            if (merchant != null){
                if (merchant.getIsLogin() == 1){
                    try {
                        Subject subject = SecurityUtils.getSubject();//从安全管理器中获取主体对象
                        UsernamePasswordToken token=new UsernamePasswordToken(username,password); //构建令牌对象
                        subject.login(token);
                        if(subject.isAuthenticated()){//判断是否正确登录
                            //用户信息与权限信息存储
                            System.out.println("登陆成功");
                            MerchantProfile profile = merchantProfileService.findById(merchant.getId());
                            request.getSession().setAttribute("user",profile);
                            request.getSession().setAttribute("user1",merchant);
                            return 4;
                        }
                    }catch (UnknownAccountException e) {
                        System.out.println("用户名问题");
                    }catch (IncorrectCredentialsException e) {
                        System.out.println("密码错误");
                        return 3;
                    }catch (AuthenticationException e){
                        e.printStackTrace();
                        System.out.println("登录失败");
                    }
                } else if (merchant.getIsLogin() == 2){
                    return 5;
                } else {
                    return 2;
                }
            }
            return 1;
        }
        return 0;
    }

    /**
     * 生成自定义的验证码
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
    private String getNumber(){
        String str="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        for(int i= 0;i<4;i++){
            int index = (int)(Math.random()*str.length());
            code+=str.charAt(index);
        }
        return code;
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        request.getSession().invalidate();
        return "redirect:login";
    }
}
