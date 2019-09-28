package com.catering.service.impl;

import com.catering.mapper.PermissionMapper;
import com.catering.pojo.AdminPermission;
import com.catering.pojo.StorePermission;
import com.catering.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<AdminPermission> findByid(int id) {
        return permissionMapper.findByid(id);
    }
}
