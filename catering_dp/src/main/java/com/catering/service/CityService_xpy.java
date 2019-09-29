package com.catering.service;

import com.catering.pojo.City;

import java.util.List;

public interface CityService_xpy {
    public List<City> findAll();
    /**
     * 根据城市名称查询id
     * @param name
     * @return
     */
    public int getCityId(String name);
}
