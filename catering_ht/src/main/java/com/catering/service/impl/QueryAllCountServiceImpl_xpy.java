package com.catering.service.impl;

import com.catering.mapper.QueryAllCount_xpy;
import com.catering.service.QueryAllCountService_xpy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QueryAllCountServiceImpl_xpy implements QueryAllCountService_xpy {
    @Resource
    private QueryAllCount_xpy queryAllCount;
    @Override
    public int findMemCount() {
        return queryAllCount.findMemCount();
    }

    @Override
    public int findMerCount() {
        return queryAllCount.findMerCount();
    }

    @Override
    public int findIndCount() {
        return queryAllCount.findIndCount();
    }

    @Override
    public int findMemuCount() {
        return queryAllCount.findMemuCount();
    }
}
