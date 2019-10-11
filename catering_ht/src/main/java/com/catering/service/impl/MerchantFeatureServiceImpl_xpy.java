package com.catering.service.impl;

import com.catering.mapper.MerchantFeatureMapper_xpy;
import com.catering.pojo.MerchantFeature;
import com.catering.service.MerchantFeatureService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantFeatureServiceImpl_xpy implements MerchantFeatureService_xpy {
    @Autowired
    private MerchantFeatureMapper_xpy featureMapper;
    @Override
    public MerchantFeature findById(int id) {
        return featureMapper.findById(id);
    }

    @Override
    public int saveFeature(MerchantFeature merchantFeature) {
        return featureMapper.saveFeature(merchantFeature);
    }

    @Override
    public int updateFeature(MerchantFeature merchantFeature) {
        return featureMapper.updateFeature(merchantFeature);
    }
}
