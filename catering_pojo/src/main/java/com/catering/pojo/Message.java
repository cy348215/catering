package com.catering.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Message implements Serializable {
    private Integer id;

    private String content;

    private Integer type;

    private String link;

    private String isSchedule;

    private String scheduleTime;

    private String sendTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getIsSchedule() {
        return isSchedule;
    }

    public void setIsSchedule(String isSchedule) {
        this.isSchedule = isSchedule == null ? null : isSchedule.trim();
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime == null ? null : scheduleTime.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }
}