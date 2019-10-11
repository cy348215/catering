package com.catering.mapper;

import com.catering.pojo.MemberProfile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberProfileMapper_xpy {
    /**
     * 根据状态查询会员信息
     * @param state
     * @return
     */
    public List<MemberProfile> findAllByState(int state);
}
