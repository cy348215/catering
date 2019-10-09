package com.catering.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper_cy {
    /**
     * 查询标签
     * @return
     */
    public List<String> findTag();
}
