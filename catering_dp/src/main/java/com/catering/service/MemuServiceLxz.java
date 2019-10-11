package com.catering.service;

import com.catering.pojo.Memu;

import java.util.List;

public interface MemuServiceLxz {
    boolean addMemu(Memu memu);
    List<Memu> findAllMemu(int page,int rows);
    int calcMaxMemu(int rows);
    List<Memu> findMemuByDid(int did);
    Double sumPrice(int did);
    boolean delMemu(int id);
    List<Memu> findRcycle();
}
