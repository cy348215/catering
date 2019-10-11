package com.catering.service.impl;

import com.catering.mapper.MemberProfileMapperLxz;
import com.catering.pojo.MemberProfile;
import com.catering.service.MemberprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberprofileImpl implements MemberprofileService {
    @Autowired
    private MemberProfileMapperLxz memberProfileMapperLxz;
    @Override
    public MemberProfile findMemberProfileById(int id) {
        return memberProfileMapperLxz.findMemberProfileById(id);
    }
}
