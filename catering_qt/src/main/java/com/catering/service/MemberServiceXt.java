package com.catering.service;

import com.catering.pojo.Member;
import com.catering.pojo.MemberProfile;

public interface MemberServiceXt {
    // 根据id查询会员信息
    public Member findMemberById(int id);
    // 根据name查询是否存在此会员
    public boolean findMemberByName(String username);
    // 根据邮箱查询是否存在此
    public boolean findMemberByEmail(String email);
    // 增加会员信息
    public boolean addMember(Member member);
    // 增加会员详细信息
    public boolean addMemberPro(MemberProfile memberProfile);
    // 对比登录名和密码是否合适
    public boolean findMember(String username,String password);
    // 更改登录状态（1启用 2 禁用 3 已登录）
    public boolean updataMemberStateById(int id);
}
