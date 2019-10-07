package com.catering.service;

import com.catering.pojo.Indent;

import java.util.List;

public interface IndentService_xpy {
    /**
     * 查询所有订单的数量
     * @return
     */
    public int findCount(int id);

    /**
     * 根据商家以及订单状态查询订单
     * @param
     * @return
     */
    public int findCountByState(int id,int state);

    /**
     * 根据商家以及订单状态查询交易总额度
     * @param
     * @return
     */
    public Float findPriceByState(int id,int state);
    /**
     * 根据下单时间查询
     * @param time
     * @return
     */
    public List<Indent> findByOrderTime(int id,String time);
}
