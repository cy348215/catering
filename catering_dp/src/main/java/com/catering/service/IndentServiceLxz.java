package com.catering.service;

import com.catering.pojo.Indent;

import java.util.List;

public interface IndentServiceLxz {
    List<Indent> fingAllIndent(int id);
    Indent findIndentByDid(int dId,int id);
    boolean revIndent(int id);
}
