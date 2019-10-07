package com.catering;

import com.catering.mapper.MemberMapperXt;
import com.catering.pojo.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test_xt {
    @Autowired
    MemberMapperXt memberMapperXt;

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
