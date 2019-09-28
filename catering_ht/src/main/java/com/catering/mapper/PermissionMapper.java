package com.catering.mapper;

import com.catering.pojo.AdminPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    public List<AdminPermission> findByid(int id);
}
