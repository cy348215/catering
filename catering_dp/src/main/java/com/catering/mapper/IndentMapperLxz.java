package com.catering.mapper;

import com.catering.pojo.Indent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IndentMapperLxz {
    List<Indent> fingAllIndent(int id);
    Indent findIndentByDid(Map<String,Integer> map);
    boolean revIndent(int id);
}
