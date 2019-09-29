package com.catering.mapper;

import com.catering.pojo.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper_xpy {
    public List<City> findAll();
}
