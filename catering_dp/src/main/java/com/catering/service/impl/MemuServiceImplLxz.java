package com.catering.service.impl;

import com.catering.mapper.MemuMapperLxz;
import com.catering.pojo.Memu;
import com.catering.service.MemuServiceLxz;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemuServiceImplLxz implements MemuServiceLxz {
    @Autowired
    private MemuMapperLxz memuMapperLxz;
    @Override
    public boolean addMemu(Memu memu) {
        return memuMapperLxz.addMemu(memu);
    }

    @Override
    public List<Memu> findAllMemu(int page,int rows) {
        PageHelper.startPage(page, rows);
        return memuMapperLxz.findAllMemu();
    }

    @Override
    public int calcMaxMemu(int rows) {
        int count=memuMapperLxz.findCount();
        return count%rows==0?count/rows:count/rows+1;
    }

    @Override
    public List<Memu> findMemuByDid(int did) {
        return memuMapperLxz.findMemuByDid(did);
    }

    @Override
    public Double sumPrice(int did) {
        return memuMapperLxz.sumPrice(did);
    }

    @Override
    public boolean delMemu(int id) {
        return memuMapperLxz.delMemu(id);
    }

    @Override
    public List<Memu> findRcycle() {
        return memuMapperLxz.findRcycle();
    }
}
