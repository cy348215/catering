package com.catering.service;

import com.catering.pojo.Indent;
import com.catering.pojo.Memu;
import com.catering.pojo.MerchantProfile;

import java.util.List;
import java.util.Map;

public interface ReservationService_xt {
    /**
     * 根据id查询出这个店铺
     * @param id
     * @return
     */
    public MerchantProfile findMerchantProById(int id);

    /**
     * 根据店铺id查询所有菜品信息
     * @param merchantId
     * @return
     */
    public List<Memu> findAllMemuById(int merchantId);

    /**
     * 根据菜品id查询这个菜的详细信息
     * @param id
     * @return
     */
    public Memu findMemuById(int id);

    /**
     * 添加indent-mume表单数据 indentId MumeID
     * @param map
     * @return
     */
    public int addIndentMemu(Map<String,Integer> map);

    /**
     * 添加新的订单
     * @param indent
     * @return
     */
    public int addIndent(Indent indent);
}
