package com.catering.service.impl;

import com.catering.mapper.IndentMapperLxz;
import com.catering.pojo.Indent;
import com.catering.service.IndentServiceLxz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndentServiceImplLxz implements IndentServiceLxz {
    @Autowired
    private IndentMapperLxz indentMapperLxz;
    @Override
    public List<Indent> fingAllIndent(int id) {
        return indentMapperLxz.fingAllIndent(id);
    }

    @Override
    public Indent findIndentByDid(int dId,int id) {
        Map<String,Integer> map = new HashMap<>();
        map.put("dId",dId);
        map.put("id",id);
        return indentMapperLxz.findIndentByDid(map);
    }

    @Override
    public boolean revIndent(int id) {
        return indentMapperLxz.revIndent(id);
    }
}
