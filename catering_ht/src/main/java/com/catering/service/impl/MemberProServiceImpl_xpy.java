package com.catering.service.impl;

import com.catering.mapper.MemberProfileMapper_xpy;
import com.catering.pojo.MemberProfile;
import com.catering.service.MemberProService_xpy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberProServiceImpl_xpy implements MemberProService_xpy {
    @Resource
    private MemberProfileMapper_xpy memberProfileMapper;
    @Override
    public List<MemberProfile> findAllByState(int state) {
        return memberProfileMapper.findAllByState(state);
    }
}
