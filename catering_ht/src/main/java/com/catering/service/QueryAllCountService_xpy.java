package com.catering.service;

public interface QueryAllCountService_xpy {
    /**
     * 查询会员数量
     * @return
     */
    public int findMemCount();

    /**
     * 查询店铺信息
     * @return
     */
    public int findMerCount();

    /**
     * 查询订单数量
     * @return
     */
    public int findIndCount();

    /**
     * 查询产品数量
     * @return
     */
    public int findMemuCount();
}
