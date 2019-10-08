package com.catering.service;

import com.catering.pojo.Comment;

import java.util.List;

public interface CommentService_xpy {
    /**
     * 根据id查询评论详情
     * @param id
     * @return
     */
    public Comment findAllById(int id,int mid);
    /**
     * 根据类型查询信息
     * @param type
     * @return
     */
    public List<Comment> findAllByType(int page,int rows,String type,int mid);

    /**
     * 查询根据类型分页的数据最大页码
     * @param rows
     * @param type
     * @return
     */
    public int getMaxPage(int rows,String type,int mid);

    /**
     * 修改评论
     * @param comment
     * @return
     */
    public int updateComment(Comment comment);
    /**
     * 根据id删除评论信息
     * @param id
     * @return
     */
    public int deleteComment(int id);
}
