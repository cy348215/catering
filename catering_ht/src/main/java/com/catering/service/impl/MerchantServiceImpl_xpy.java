package com.catering.service.impl;

import com.catering.mapper.MerchantMapper_xpy;
import com.catering.pojo.Merchant;
import com.catering.pojo.StorePermission;
import com.catering.service.MerchantService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MerchantServiceImpl_xpy implements MerchantService_xpy {
    @Resource
    private MerchantMapper_xpy merchantMapper;

    @Override
    public int updateIs(int id, int is) {
        Map<String,Integer> map = new HashMap<>();
        map.put("id",id);
        map.put("is",is);
        return merchantMapper.updateIs(map);
    }

    @Override
    public int delById(int id) {
        return merchantMapper.delById(id);
    }

    @Override
    public int findids(int isl) {
        return merchantMapper.findids(isl);
    }

    @Override
    public int updatePassword(int id, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("password",password);
        return merchantMapper.updatePassword(map);
    }

    @Override
    public int saveMerchant(Merchant merchant) {
        return merchantMapper.saveMerchant(merchant);
    }

    @Override
    public int findMerchant(String username) {
        return merchantMapper.findMerchant(username);
    }

    @Override
    public Merchant findMerchantByName(String username) {
        return merchantMapper.findMerchantByName(username);
    }

    @Override
    public List<StorePermission> findPermissionById(int id) {
        return merchantMapper.findPermissionById(id);
    }
}
