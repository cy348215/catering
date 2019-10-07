package com.catering.service.impl;

import com.catering.mapper.MemberMapperXt;
import com.catering.pojo.Member;
import com.catering.pojo.MemberProfile;
import com.catering.service.MemberServiceXt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl_Xt implements MemberServiceXt {
    @Autowired
    MemberMapperXt memberMapperXt;
    @Override
    public Member findMemberById(int id) {
        return memberMapperXt.findMemberById(id);
    }

    @Override
    public boolean findMemberByName(String username) {
        int count = memberMapperXt.findMemberByName(username);
        return count>0?true:false;
    }

    @Override
    public boolean findMemberByEmail(String email) {
        int count = memberMapperXt.findMemberByEmail(email);
        return count>0?true:false;
    }

    @Override
    public boolean addMember(Member member) {
        int count = memberMapperXt.addMember(member);
        return count>0?true:false;
    }

    @Override
    public boolean addMemberPro(MemberProfile memberProfile) {
        int count  = memberMapperXt.addMemberPro(memberProfile);
        return count>0?true:false;
    }

    @Override
    public boolean findMember(String username,String password) {
        Map<String ,String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        Member member = memberMapperXt.findMember(map);
        return false;
    }

    @Override
    public boolean updataMemberStateById(int id) {
        int count = memberMapperXt.updataMemberStateById(id);
        return count>0?true:false;
    }
}
