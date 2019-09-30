package com.catering.mapper;

import com.catering.pojo.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper_xpy {
    /**
     * 查询所有城市信息
     * @return
     */
    public List<City> findAll();

    /**
     * 根据城市名称查询id
     * @param name
     * @return
     */
    public int getCityId(String name);
}
