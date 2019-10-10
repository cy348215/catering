package com.catering;

import com.catering.mapper.MemberMapperXt;
import com.catering.pojo.Member;
import com.catering.service.MemberServiceXt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test_xt {
    @Autowired
    MemberMapperXt memberMapperXt;

    @Resource
    MemberServiceXt memberServiceXt;



    @Test
    public void test4(){
        String username = "admin";
        String password = "123456s";
       Member member = new Member();
       member.setUsername(username);
       member.setPassword(password);
        boolean b = memberServiceXt.findMemberByName(username);
        System.out.println("b = " + b);

    }
    @Test
    public void test3(){
        String username = "admin";
        String password = "123456s";
        Map<String ,String > map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        System.out.println("map = " + map);
        Member member = memberMapperXt.findMemberByName(username);
        System.out.println("member = " + member);
    }
    @Test
    public void test2(){
        String username = "admin";
        String password = "123456s";
        Map<String ,String > map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        System.out.println("map = " + map);
        int id=1;
        Member member = memberMapperXt.findMember(map);
        System.out.println("member = " + member);

    }

    @Test
    public void test1(){
        String username = "admin";
        String password = "123456";
        Map<String ,String > map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        System.out.println("map = " + map);
        int id=1;
        Member member = memberMapperXt.findMemberById(id);
        System.out.println("member = " + member);

    }
}
