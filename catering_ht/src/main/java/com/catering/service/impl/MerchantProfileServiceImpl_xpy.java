package com.catering.service.impl;

import com.catering.mapper.MerchantProfileMapper_xpy;
import com.catering.pojo.MerchantProfile;
import com.catering.service.MerchantProfileService_xpy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MerchantProfileServiceImpl_xpy implements MerchantProfileService_xpy {
    @Resource
    private MerchantProfileMapper_xpy merchantProfileMapper;

    @Override
    public List<MerchantProfile> findTime(String time) {
        return merchantProfileMapper.findTime(time);
    }

    @Override
    public int delById(int id) {
        return merchantProfileMapper.delById(id);
    }

    @Override
    public List<MerchantProfile> findByisl(int id) {
        return merchantProfileMapper.findByisl(id);
    }

    @Override
    public boolean checkname(String storename) {
        boolean bool = false;
        if (merchantProfileMapper.checkname(storename) == null){
            bool = true;
        }
        return bool;
    }

    @Override
    public boolean checkmember(String storemember) {
        boolean bool = false;
        if (merchantProfileMapper.checkmember(storemember) == null){
            bool = true;
        }
        return bool;
    }

    @Override
    public boolean checkphone(String phone) {
        boolean bool = false;
        if (merchantProfileMapper.checkphone(phone) == null){
            bool = true;
        }
        return bool;
    }

    @Override
    public boolean checkemail(String email) {
        boolean bool = false;
        if (merchantProfileMapper.checkemail(email) == null){
            bool = true;
        }
        return bool;
    }

    @Override
    public boolean saveMerchant(MerchantProfile merchantProfile) {
        int i = merchantProfileMapper.saveMerchant(merchantProfile);
        return i>0?true:false;
    }

    @Override
    public MerchantProfile findById(int id) {
        return merchantProfileMapper.findById(id);
    }
}
