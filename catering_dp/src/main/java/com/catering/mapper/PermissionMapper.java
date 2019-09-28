package com.catering.mapper;

import com.catering.pojo.StorePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper {
    public List<StorePermission> findByid(int id);
}
