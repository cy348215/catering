package com.catering.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class MemberFav implements Serializable {
    private Integer id;

    private Integer memberId;

    private Integer contentId;

    private Integer favType;

    private String favTime;

    private String favIp;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getFavType() {
        return favType;
    }

    public void setFavType(Integer favType) {
        this.favType = favType;
    }

    public String getFavTime() {
        return favTime;
    }

    public void setFavTime(String favTime) {
        this.favTime = favTime == null ? null : favTime.trim();
    }

    public String getFavIp() {
        return favIp;
    }

    public void setFavIp(String favIp) {
        this.favIp = favIp == null ? null : favIp.trim();
    }
}