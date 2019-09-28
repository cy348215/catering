package com.catering.pojo;

import lombok.Data;

@Data
public class StorePermission {
    private int id;
    private int pid;
    private String pname;
    private String url;
    private int status;
}
