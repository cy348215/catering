package com.catering.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Comment implements Serializable {
    private int id;
    private String type;
    private String account;
    private String createTime;
    private String state;
    private String content;
    private String reply;
    private String dealTime;
    private int merchantId;
    private int orderNumber;
    private int menuId;
    private Memu memu;
}