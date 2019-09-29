package com.catering.service.impl;

import com.catering.mapper.CityMapper_xpy;
import com.catering.pojo.City;
import com.catering.service.CityService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl_xpy implements CityService_xpy {
    @Autowired
    private CityMapper_xpy cityMapper;
    @Override
    public List<City> findAll() {
        return cityMapper.findAll();
    }

    @Override
    public int getCityId(String name) {
        return cityMapper.getCityId(name);
    }
}
