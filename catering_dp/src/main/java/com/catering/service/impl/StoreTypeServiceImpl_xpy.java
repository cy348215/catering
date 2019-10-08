package com.catering.service.impl;

import com.catering.mapper.StoreTypeMapper_xpy;
import com.catering.pojo.StoreType;
import com.catering.service.StoreTypeService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreTypeServiceImpl_xpy implements StoreTypeService_xpy {
    @Autowired
    private StoreTypeMapper_xpy storeTypeMapper;
    @Override
    public List<StoreType> findAll() {
        return storeTypeMapper.findAll();
    }

    @Override
    public int findByName(String name) {
        return storeTypeMapper.findByName(name);
    }
}
