package com.catering.mapper;

import com.catering.pojo.Member;
import com.catering.pojo.MemberProfile;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapperXt {
    // 根据id查询会员信息
    public Member findMemberById(int id);
    // 根据name查询是否存在此会员
    public int findMemberByName(String username);
    // 根据邮箱查询是否存在此
    public int findMemberByEmail(String email);
    // 增加会员信息
    public int addMember(Member member);
    // 增加会员详细信息
    public int addMemberPro(MemberProfile memberProfile);
    // 根据密码账户查询用户信息
    public Member findMember(Map<String ,String> map);
    // 更改登录状态（1启用 2 禁用 3 已登录）
    public int updataMemberStateById(int id);

}
