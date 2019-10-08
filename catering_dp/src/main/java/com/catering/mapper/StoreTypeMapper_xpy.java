package com.catering.mapper;

import com.catering.pojo.StoreType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreTypeMapper_xpy {
    /**
     * 查询所有餐厅类型
     * @return
     */
    public List<StoreType> findAll();

    /**
     * 根据类型名称查询id
     * @param name
     * @return
     */
    public int findByName(String name);
}
