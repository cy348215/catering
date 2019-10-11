package com.catering.controller;

import com.catering.pojo.AdminUser;
import com.catering.service.AdminUserService_xpy;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private AdminUserService_xpy adminUserService;
    @ResponseBody
    @RequestMapping("/dealLogin")
    public int dealLogin(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("code") String code, HttpServletRequest request){
        AdminUser adminUser = adminUserService.findAdminByName(username);
        String number = (String) request.getSession().getAttribute("number");
        if (number.equalsIgnoreCase(code)){
            try {
                Subject subject = SecurityUtils.getSubject();//从安全管理器中获取主体对象
                UsernamePasswordToken token=new UsernamePasswordToken(username,password); //构建令牌对象
                subject.login(token);
                if(subject.isAuthenticated()){//判断是否正确登录
                    //用户信息与权限信息存储
                    System.out.println("登陆成功");
                    request.getSession().setAttribute("admin",adminUser.getName());
                    return 1;
                }
            }catch (UnknownAccountException e) {
                System.out.println("用户名问题");
            }catch (IncorrectCredentialsException e) {
                System.out.println("密码错误");
            }catch (AuthenticationException e){
                e.printStackTrace();
                System.out.println("登录失败");
            }
            return 0;
        }
        return 2;
    }
}
