package com.catering.service.impl;

import com.catering.mapper.IndentMapper_xpy;
import com.catering.pojo.Indent;
import com.catering.service.IndentService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndentServiceImpl_xpy implements IndentService_xpy {
    @Resource
    private IndentMapper_xpy indentMapper;
    @Override
    public int findCount(int id) {
        return indentMapper.findCount(id);
    }

    @Override
    public int findCountByState(int id, int state) {
        Map<String,Integer> map = new HashMap<>();
        map.put("id",id);
        map.put("state",state);
        return indentMapper.findCountByState(map);
    }

    @Override
    public Float findPriceByState(int id, int state) {
        Map<String,Integer> map = new HashMap<>();
        map.put("id",id);
        map.put("state",state);
        return indentMapper.findPriceByState(map);
    }

    @Override
    public List<Indent> findByOrderTime(int id,String time) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("time",time);
        return indentMapper.findByOrderTime(map);
    }
}
