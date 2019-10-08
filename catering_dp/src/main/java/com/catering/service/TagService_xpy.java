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
    /**
     * 添加店铺的标签
     * @param
     * @return
     */
    public int saveTypeTag(int mid,int tid);
    /**
     * 删除商家的标签
     * @param
     * @return
     */
    public int deleteTypeTag(int mid,int tid);

    /**
     * 查询指定id的商家的标签
     * @param id
     * @return
     */
    public List<Tag> findAllMer(int id);
}
