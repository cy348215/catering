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


}
