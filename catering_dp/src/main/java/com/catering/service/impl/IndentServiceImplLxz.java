package com.catering.service.impl;

import com.catering.mapper.IndentMapperLxz;
import com.catering.pojo.Indent;
import com.catering.service.IndentServiceLxz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IndentServiceImplLxz implements IndentServiceLxz {
    @Autowired
    private IndentMapperLxz indentMapperLxz;
    @Override
    public List<Indent> fingAllIndent() {
        return indentMapperLxz.fingAllIndent();
    }

    @Override
    public Indent findIndentByDid(int dId) {
        return indentMapperLxz.findIndentByDid(dId);
    }

    @Override
    public boolean revIndent(int id) {
        return indentMapperLxz.revIndent(id);
    }
}
