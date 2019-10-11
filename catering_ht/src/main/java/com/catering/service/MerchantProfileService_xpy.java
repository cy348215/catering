package com.catering.service;

import com.catering.pojo.MerchantProfile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantProfileService_xpy {
    /**
     * 根据时间查询
     * @param time
     * @return
     */
    public List<MerchantProfile> findTime(String time);
    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    public int delById(int id);
    /**
     *
     * @param list
     * @return
     */
    public List<MerchantProfile> findByisl(int id);
    /**
     * 检查店名是否重复
     * @param storename
     * @return
     */
    public boolean checkname(String storename);

    /**
     * 检查许可证编号
     * @param storemember
     * @return
     */
    public boolean checkmember(String storemember);

    /**
     * 检查电话号
     * @param phone
     * @return
     */
    public boolean checkphone(String phone);

    /**
     * 检查邮箱
     * @param email
     * @return
     */
    public boolean checkemail(String email);
    /**
     * 添加店铺
     * @param merchantProfile
     * @return
     */
    public boolean saveMerchant(@Param(("merchantProfile")) MerchantProfile merchantProfile);
    /**
     * 根据id查询店铺信息
     * @param id
     * @return
     */
    public MerchantProfile findById(int id);
}
