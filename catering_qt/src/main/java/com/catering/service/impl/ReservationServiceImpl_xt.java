package com.catering.service.impl;

import com.catering.mapper.ReservationMapper_xt;
import com.catering.pojo.Indent;
import com.catering.pojo.Memu;
import com.catering.pojo.MerchantProfile;
import com.catering.service.ReservationService_xt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImpl_xt implements ReservationService_xt {
    @Autowired
    ReservationMapper_xt reservationMapper_xt;

    @Override
    public MerchantProfile findMerchantProById(int id) {
        return reservationMapper_xt.findMerchantProById(id);
    }

    @Override
    public List<Memu> findAllMemuById(int merchantId) {
        return reservationMapper_xt.findAllMemuById(merchantId);
    }

    @Override
    public Memu findMemuById(int id) {
        return reservationMapper_xt.findMemuById(id);
    }

    @Override
    public int addIndentMemu(Map<String, Integer> map) {
        return reservationMapper_xt.addIndentMemu(map);
    }

    @Override
    public int addIndent(Indent indent) {
        return reservationMapper_xt.addIndent(indent);
    }

    @Override
    public Indent findIndentById(int indentId) {
        return reservationMapper_xt.findIndentById(indentId);
    }

    @Override
    public List<Memu> findIndentAllMenuById2(int indentId) {
        return reservationMapper_xt.findIndentAllMenuById2(indentId);
    }
}
