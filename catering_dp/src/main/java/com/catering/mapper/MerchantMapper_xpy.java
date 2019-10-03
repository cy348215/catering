package com.catering.mapper;

import com.catering.pojo.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MerchantMapper_xpy {
    /**
     * 添加账号
     * @param merchant
     * @return
     */
    public int saveMerchant(@Param("merchant")Merchant merchant);

    /**
     * 根据账号查询id
     * @param username
     * @return
     */
    public int findMerchant(String username);

    /**
     * 根据账号查询信息
     * @param username
     * @return
     */
    public Merchant findMerchantByName(String username);
}
