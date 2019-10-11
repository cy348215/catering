package com.catering.service;

import com.catering.pojo.Memu;
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
    /**
     * 通过店铺id查出所有店铺所有信息
     * @param map
     * @return
     */
    public List<String> searchMer1(int i);
    /**
     * 查出所有店铺
     * @return
     */
    public List<String> searchTag1();
    /**
     * 查出所有前十个标签
     */
    public List<String> findTag1();
    /**
     * 查出有限的地点
     * @return
     */
    public List<String> findCity();
    /**
     * 查出所有的地点
     * @return
     */
    public List<String> findCity1();
    /**
     *查询店铺图片
     */
    public List<String> findImg1();
    /**
     *查询店铺图片
     */
    public List<String> findImg2();
    /**
     *查询店铺图片
     */
    public List<String> findImg3();
    /**
     * 通过图片查id
     * @param img1
     * @return
     */
    public int searchInt1(String img1);
    /**
     * 通过图片查id
     * @param img2
     * @return
     */
    public int searchInt2(String img2);
    /**
     * 通过图片查id
     * @param img3
     * @return
     */
    public int searchInt3(String img3);

    /**
     * 通过id查菜谱
     * @param merchantId
     * @return
     */
    public List<Memu> findDish(int merchantId);
}
