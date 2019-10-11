package com.catering.service;

import com.catering.pojo.Indent;

import java.util.List;

public interface IndentServiceLxz {
    List<Indent> fingAllIndent();
    Indent findIndentByDid(int dId);
    boolean revIndent(int id);
}
