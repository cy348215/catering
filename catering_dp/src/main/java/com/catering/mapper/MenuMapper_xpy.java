package com.catering.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper_xpy {
    /**
     * 根据店铺id查询产品数量
     * @param id
     * @return
     */
    public int findCount(int id);
}
