package com.catering.service;

import com.catering.pojo.AdminPermission;

import java.util.List;

public interface PermissionService {
    public List<AdminPermission> findByid(int id);
}
