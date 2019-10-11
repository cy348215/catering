package com.catering.service;

import com.catering.pojo.MerchantFeature;
import org.apache.ibatis.annotations.Param;

public interface MerchantFeatureService_xpy {
    /**
     * 根据店铺id查询信息
     * @param id
     * @return
     */
    public MerchantFeature findById(int id);

    /**
     * 添加信息
     * @param merchantFeature
     * @return
     */
    public int saveFeature(@Param("feature") MerchantFeature merchantFeature);

    /**
     * 修改信息根据id
     * @param merchantFeature
     * @return
     */
    public int updateFeature(@Param("feature") MerchantFeature merchantFeature);
}
