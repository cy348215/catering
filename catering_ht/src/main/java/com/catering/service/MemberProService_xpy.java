package com.catering.service;

import com.catering.pojo.MemberProfile;

import java.util.List;

public interface MemberProService_xpy {
    /**
     * 根据状态查询会员信息
     * @param state
     * @return
     */
    public List<MemberProfile> findAllByState(int state);
}
