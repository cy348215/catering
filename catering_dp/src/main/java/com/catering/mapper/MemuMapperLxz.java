package com.catering.mapper;

import com.catering.pojo.Memu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemuMapperLxz {
    boolean addMemu(Memu memu);
    List<Memu> findAllMemu();
    int findCount();
    List<Memu> findMemuByDid(int did);
    Double sumPrice(int did);


}
