package com.catering.pojo;

import lombok.Data;

@Data
public class Tag {
    private int cuisineId;
    private String cuisineName;
    private int isMake;
    private int isBoolean=0;
    private String createTime;
    private String updateTime;
}
