package com.catering.service;

import com.catering.pojo.Memu;

public interface MenuService_xpy {
    /**
     * 根据店铺id查询产品数量
     * @param id
     * @return
     */
    public int findCount(int id);

    public Memu findById(int id);
}
