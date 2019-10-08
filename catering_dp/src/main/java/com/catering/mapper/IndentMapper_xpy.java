package com.catering.mapper;

import com.catering.pojo.Indent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface IndentMapper_xpy {
    /**
     * 查询所有订单的数量
     * @return
     */
    public int findCount(int id);

    /**
     * 根据商家以及订单状态查询订单
     * @param map
     * @return
     */
    public int findCountByState(Map<String,Integer> map);

    /**
     * 根据商家以及订单状态查询交易总额度
     * @param map
     * @return
     */
    public Float findPriceByState(Map<String,Integer> map);

    /**
     * 根据下单时间查询
     * @param
     * @return
     */
    public List<Indent> findByOrderTime(Map<String,Object> map);
}
