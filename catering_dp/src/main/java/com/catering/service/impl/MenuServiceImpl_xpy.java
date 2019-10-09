package com.catering.service.impl;

import com.catering.mapper.MenuMapper_xpy;
import com.catering.pojo.Memu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl_xpy implements MenuMapper_xpy {
    @Autowired
    private MenuMapper_xpy menuMapper;
    @Override
    public int findCount(int id) {
        return menuMapper.findCount(id);
    }

    @Override
    public Memu findById(int id) {
        return menuMapper.findById(id);
    }
}
