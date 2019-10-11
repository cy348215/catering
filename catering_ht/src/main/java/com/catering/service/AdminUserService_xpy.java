package com.catering.service;

import com.catering.pojo.AdminPermission;
import com.catering.pojo.AdminUser;

import java.util.List;

public interface AdminUserService_xpy {
    /**
     * 根据账号查询
     * @param name
     * @return
     */
    public AdminUser findAdminByName(String name);

    /**
     * 根据账号id查询账号权限
     * @param id
     * @return
     */
    public List<AdminPermission> findAdminPer(int id);
}
