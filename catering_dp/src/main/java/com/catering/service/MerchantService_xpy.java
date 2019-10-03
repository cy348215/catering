package com.catering.service;

import com.catering.pojo.Merchant;

public interface MerchantService_xpy {
    /**
     * 添加账号
     * @param merchant
     * @return
     */
    public int saveMerchant(Merchant merchant);
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
