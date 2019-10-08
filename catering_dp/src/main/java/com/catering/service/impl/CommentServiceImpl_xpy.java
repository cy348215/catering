package com.catering.service.impl;

import com.catering.mapper.CommentMapper_xpy;
import com.catering.pojo.Comment;
import com.catering.service.CommentService_xpy;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl_xpy implements CommentService_xpy {
    @Resource
    private CommentMapper_xpy commentMapper;

    @Override
    public Comment findAllById(int id,int mid) {
        Map<String,Integer> map = new HashMap<>();
        map.put("id",id);
        map.put("mid",mid);
        return commentMapper.findAllById(map);
    }

    @Override
    public List<Comment> findAllByType(int page,int rows,String type,int mid) {
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("mid",mid);
        PageHelper.startPage(page, rows);
        return commentMapper.findAllByType(map);
    }

    @Override
    public int getMaxPage(int rows, String type,int mid) {
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("mid",mid);
        int count = commentMapper.getCountType(map);
        int page = count%rows==0?count/rows:count/rows+1;
        return page;
    }

    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }

    @Override
    public int deleteComment(int id) {
        return commentMapper.deleteComment(id);
    }
}
