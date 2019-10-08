package com.catering.service.impl;

import com.catering.mapper.MemberMapper_cy;
import com.catering.service.MemberService_cy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberServiceImpl_cy implements MemberService_cy {
    @Resource
    private MemberMapper_cy memberMapper_cy;
    @Override
    public List<String> findTag() {
        List<String> tag = memberMapper_cy.findTag();
        return tag;
    }
}
