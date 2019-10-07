package com.catering.mapper;

import com.catering.pojo.Merchant;
import com.catering.pojo.StorePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MerchantMapper_xpy {
    /**
     * 根据id修改用户的密码
     * @param map
     * @return
     */
    public int updatePassword(Map<String,Object> map);
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

    /**
     * 根据用户id查询用户的权限
     * @param id
     * @return
     */
    public List<StorePermission> findPermissionById(int id);
}
