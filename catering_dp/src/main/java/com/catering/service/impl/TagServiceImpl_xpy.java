package com.catering.service.impl;

import com.catering.mapper.TagMapper_xpy;
import com.catering.pojo.Tag;
import com.catering.service.TagService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl_xpy implements TagService_xpy {
    @Autowired
    private TagMapper_xpy tagMapper;
    @Override
    public List<Tag> findAll() {
        return tagMapper.findAll();
    }
}
