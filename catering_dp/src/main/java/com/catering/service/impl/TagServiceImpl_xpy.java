package com.catering.service.impl;

import com.catering.mapper.TagMapper_xpy;
import com.catering.pojo.Tag;
import com.catering.service.TagService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl_xpy implements TagService_xpy {
    @Autowired
    private TagMapper_xpy tagMapper;
    @Override
    public List<Tag> findAll() {
        return tagMapper.findAll();
    }

    @Override
    public int findByName(String name) {
        return tagMapper.findByName(name);
    }

    @Override
    public int saveTypeTag(int mid, int tid) {
        Map<String,Integer> map = new HashMap<>();
        map.put("mid",mid);
        map.put("tid",tid);
        return tagMapper.saveTypeTag(map);
    }

    @Override
    public int deleteTypeTag(int mid, int tid) {
        Map<String,Integer> map = new HashMap<>();
        map.put("mid",mid);
        map.put("tid",tid);
        return tagMapper.deleteTypeTag(map);
    }

    @Override
    public List<Tag> findAllMer(int id) {
        return tagMapper.findAllMer(id);
    }
}
