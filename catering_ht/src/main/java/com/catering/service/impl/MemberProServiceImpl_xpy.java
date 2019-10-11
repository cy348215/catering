package com.catering.service.impl;

import com.catering.mapper.MemberProfileMapper_xpy;
import com.catering.pojo.Member;
import com.catering.pojo.MemberProfile;
import com.catering.service.MemberProService_xpy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberProServiceImpl_xpy implements MemberProService_xpy {
    @Resource
    private MemberProfileMapper_xpy memberProfileMapper;

    @Override
    public List<MemberProfile> query(String tiao,String time) {
        Map<String,String> map = new HashMap<>();
        map.put("tiao",tiao);
        map.put("time",time);
        return memberProfileMapper.query(map);
    }

    @Override
    public List<MemberProfile> findAllByState(int state) {
        return memberProfileMapper.findAllByState(state);
    }

    @Override
    public List<MemberProfile> findAll() {
        return memberProfileMapper.findAll();
    }

    @Override
    public MemberProfile findById(int id) {
        return memberProfileMapper.findById(id);
    }

    @Override
    public Member findMember(int id) {
        return memberProfileMapper.findMember(id);
    }

    @Override
    public int saveMember(Member member) {
        return memberProfileMapper.saveMember(member);
    }

    @Override
    public int savePro(MemberProfile memberProfile) {
        return memberProfileMapper.savePro(memberProfile);
    }

    @Override
    public int updateMemberPass(Member member) {
        return memberProfileMapper.updateMemberPass(member);
    }

    @Override
    public int updateMemberState(Member member) {
        return memberProfileMapper.updateMemberState(member);
    }

    @Override
    public int updatePro(MemberProfile memberProfile) {
        return memberProfileMapper.updatePro(memberProfile);
    }

    @Override
    public int delMember(int id) {
        return memberProfileMapper.delMember(id);
    }

    @Override
    public int delPro(int id) {
        return memberProfileMapper.delPro(id);
    }

    @Override
    public Member findByName(String name) {
        return memberProfileMapper.findByName(name);
    }

}
