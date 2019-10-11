package com.catering.mapper;

import com.catering.pojo.MemberProfile;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberProfileMapperLxz {
    MemberProfile findMemberProfileById(int id);
}
