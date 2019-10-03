package com.catering.mapper;

import com.catering.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper_xpy {
    public List<Tag> findAll();

    /**
     * 根据标签名查询id
     * @param name
     * @return
     */
    public int findByName(String name);
}
