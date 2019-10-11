package com.catering.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class AdminUser implements Serializable {
    private int id;
    private String username;
    private String password;
    private String name;
    private String salt;
    private String phone;
    private String email;
    private int status;
    private String create_time;
    private int is_super;
    private String consumer;
    private String remark;
    private  String dept;
}
