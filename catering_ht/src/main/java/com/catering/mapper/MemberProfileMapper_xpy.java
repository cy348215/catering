package com.catering.mapper;

import com.catering.pojo.Member;
import com.catering.pojo.MemberProfile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberProfileMapper_xpy {
    /**
     * 条件模糊查询
     * @param map
     * @return
     */
    public List<MemberProfile> query(Map<String,String> map);
    /**
     * 根据状态查询会员信息
     * @param state
     * @return
     */
    public List<MemberProfile> findAllByState(int state);

    /**
     * 查询所有会员的信息
     * @return
     */
    public List<MemberProfile> findAll();

    /**
     * 根据id查询会员的信息
     * @return
     */
    public MemberProfile findById(int id);
    public Member findMember(int id);

    /**
     * 添加会员
     * @param member
     * @return
     */
    public int saveMember(Member member);
    public int savePro(MemberProfile memberProfile);

    /**
     * 修改密码
     * @param member
     * @return
     */
    public int updateMemberPass(Member member);

    /**
     * 修改账号状态
     * @param member
     * @return
     */
    public int updateMemberState(Member member);

    /**
     * 修改会员信息
     * @param memberProfile
     * @return
     */
    public int updatePro(MemberProfile memberProfile);

    /**
     * 根据id删除会员信息
     * @param id
     * @return
     */
    public int delMember(int id);
    public int delPro(int id);

    /**
     * 根据用户账号查找用户
     * @param name
     * @return
     */
    public Member findByName(String name);

}
