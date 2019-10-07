package com.catering.service;

import com.catering.pojo.StoreType;

import java.util.List;

public interface StoreTypeService_xpy {
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
