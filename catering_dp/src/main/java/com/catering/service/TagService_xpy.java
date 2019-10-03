package com.catering.service;

import com.catering.pojo.Tag;

import java.util.List;

public interface TagService_xpy {
    public List<Tag> findAll();
    /**
     * 根据标签名查询id
     * @param name
     * @return
     */
    public int findByName(String name);
}
