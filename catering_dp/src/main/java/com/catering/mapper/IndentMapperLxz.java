package com.catering.mapper;

import com.catering.pojo.Indent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndentMapperLxz {
    List<Indent> fingAllIndent();
    Indent findIndentByDid(int dId);
    boolean revIndent(int id);
}
