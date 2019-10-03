package com.catering.service;

import com.catering.pojo.MerchantProfile;
import org.apache.ibatis.annotations.Param;

public interface MerchantProfileService_xpy {
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
}
