package com.catering.service;

import com.catering.pojo.StorePermission;

import java.util.List;

public interface PermissionService {
    public List<StorePermission> findByid(int id);
}
