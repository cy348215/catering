package com.catering.service.impl;

import com.catering.mapper.MemberMapper_cy;
import com.catering.pojo.MerchantFeature;
import com.catering.pojo.Tag;
import com.catering.service.MemberService_cy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl_cy implements MemberService_cy {
    @Resource
    private MemberMapper_cy memberMapper_cy;
    @Override
    public List<String> findTag() {
        List<String> tag = memberMapper_cy.findTag();
        return tag;
    }

    @Override
    public int searchTagId(String cuisineName) {
        int tagId = memberMapper_cy.searchTagId(cuisineName);
        return tagId;
    }

    @Override
    public List<Integer> searchMerId(int tagId) {
        System.out.println("tagId = " + tagId);
        List<Integer> list = memberMapper_cy.searchMerId(tagId);
        System.out.println(list);
        return list;
    }

    @Override
    public List<String> searchMer(List<Integer> list) {
        System.out.println("list = " + list);
        List<String> strings = memberMapper_cy.searchMer(list);
        System.out.println(strings);
        return strings;
    }

    @Override
    public List<String> searchMer1(int i) {
        List<String> strings = memberMapper_cy.searchMer1(i);
        return strings;
    }

    @Override
    public List<String> searchTag1() {
        List<String> merchantFeatures = memberMapper_cy.searchTag1();
        return merchantFeatures;
    }

    @Override
    public List<String> findTag1() {
        List<String> tag1 = memberMapper_cy.findTag1();
        return tag1;
    }

    @Override
    public List<String> findCity() {
        List<String> city = memberMapper_cy.findCity();
        return city;
    }

    @Override
    public List<String> findCity1() {
        List<String> city1 = memberMapper_cy.findCity1();
        return city1;
    }

    @Override
    public List<String> findImg1() {
        List<String> img = memberMapper_cy.findImg1();
        return img;
    }

    @Override
    public List<String> findImg2() {
        List<String> img = memberMapper_cy.findImg2();
        return img;
    }

    @Override
    public List<String> findImg3() {
        List<String> img = memberMapper_cy.findImg3();
        return img;
    }

    @Override
    public int searchInt1(String img1) {
        int i = memberMapper_cy.searchInt1(img1);
        return i;
    }

    @Override
    public int searchInt2(String img2) {
        int i = memberMapper_cy.searchInt2(img2);
        return i;
    }

    @Override
    public int searchInt3(String img3) {
        int i = memberMapper_cy.searchInt3(img3);
        return i;
    }

    @Override
    public MerchantFeature findMerchantFeaByIdXt(int id) {
        return memberMapper_cy.findMerchantFeaByIdXt(id);
    }

}
