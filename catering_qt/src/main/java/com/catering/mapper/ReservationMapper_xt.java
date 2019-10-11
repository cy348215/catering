package com.catering.mapper;

import com.catering.pojo.Indent;
import com.catering.pojo.Memu;
import com.catering.pojo.MerchantProfile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReservationMapper_xt {
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

    /**
     * 查询是否在这个订单中存在这个菜品
     * @param map
     * @return
     */
    public int findIndentMenuXt(Map<String,Integer> map);

    /**
     * 根据订单id查询订单
     * @param indentId
     * @return
     */
    public Indent findIndentById(int indentId);

    /**
     * 根据indentid查询这个订单所拥有的菜品信息
     * @param list
     * @return
     */
    public List<Memu> findIndentAllMenuById(List list);

    /**
     * 根据id查询出memu id集合
     * @param indentId
     * @return
     */
    public List<Integer> findIndentMenuById(int indentId);

    /**
     * 根据indentid查询这个订单所拥有的菜品信息
     * @param indentId
     * @return
     */
    public List<Memu> findIndentAllMenuById2(int indentId);
}
