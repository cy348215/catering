package com.catering.mapper;

import com.catering.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TagMapper_xpy {
    public List<Tag> findAll();

    /**
     * 根据标签名查询id
     * @param name
     * @return
     */
    public int findByName(String name);

    /**
     * 添加店铺的标签
     * @param map
     * @return
     */
    public int saveTypeTag(Map<String,Integer> map);
    /**
     * 删除商家的标签
     * @param map
     * @return
     */
    public int deleteTypeTag(Map<String,Integer> map);

    /**
     * 查询指定id的商家的标签
     * @param id
     * @return
     */
    public List<Tag> findAllMer(int id);
}
