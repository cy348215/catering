package com.catering.mapper;

import com.catering.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper_xpy {
    /**
     * 根据id查询评论详情
     * @param id
     * @return
     */
    public Comment findAllById(Map<String,Integer> map);
    /**
     * 根据类型查询信息
     * @param type
     * @return
     */
    public List<Comment> findAllByType(Map<String,Object> map);

    /**
     * 查询此类评论的数量
     * @param type
     * @return
     */
    public int getCountType(Map<String,Object> map);

    /**
     * 修改评论
     * @param comment
     * @return
     */
    public int updateComment(@Param("comment") Comment comment);

    /**
     * 根据id删除评论信息
     * @param id
     * @return
     */
    public int deleteComment(int id);
}
