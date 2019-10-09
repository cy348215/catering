package com.catering.service;

import com.catering.pojo.MerchantFeature;
import com.catering.pojo.Tag;

import java.util.List;
import java.util.Map;

public interface MemberService_cy {
    /**
     * 查询标签
     * @return
     */
    public List<String> findTag();
    /**
     * 通过标签名查标签id
     * @param cuisineName
     * @return
     */
    public int searchTagId(String cuisineName);

    /**
     * 通过标签id查出店铺id
     * @param tagId
     * @return
     */
    public List<Integer> searchMerId(int tagId);

    /**
     * 通过店铺id查出所有店铺所有信息
     * @param map
     * @return
     */
    public List<String> searchMer(List<Integer> list1);

}
