package com.catering.service.impl;

import com.catering.mapper.AdminMapper_xpy;
import com.catering.pojo.AdminPermission;
import com.catering.pojo.AdminUser;
import com.catering.service.AdminUserService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminUserServiceImpl_xpy implements AdminUserService_xpy {
    @Resource
    private AdminMapper_xpy adminMapper;
    @Override
    public AdminUser findAdminByName(String name) {
        return adminMapper.findAdminByName(name);
    }

    @Override
    public List<AdminPermission> findAdminPer(int id) {
        return adminMapper.findAdminPer(id);
    }
}
