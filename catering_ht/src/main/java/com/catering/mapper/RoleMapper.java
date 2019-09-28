package com.catering.mapper;

import com.catering.pojo.AdminRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    public List<AdminRole> find();
}
