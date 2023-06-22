package com.xiao.base.BaseEntity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable{

    private String id;

    private Date createTiemed;

    private String createUserId;

    private String createUserName;

    private Date updtaeTime;

    private String updateUserId;

    private String updtaeUserName;
}
