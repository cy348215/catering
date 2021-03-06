package com.catering.service;

import com.catering.pojo.Merchant;
import com.catering.pojo.StorePermission;

import java.util.List;
import java.util.Map;

public interface MerchantService_xpy {
    /**
     * 根据id修改用户的密码
     * @param map
     * @return
     */
    public int updatePassword(int id,String password);
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
    /**
     * 根据用户id查询用户的权限
     * @param id
     * @return
     */
    public List<StorePermission> findPermissionById(int id);
}
