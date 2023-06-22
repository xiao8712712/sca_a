package com.xiao.entiy;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiao.base.BaseEntity.BaseEntity;
import lombok.Data;

@Data
@TableName("sys_roles")
public class Roles extends BaseEntity {

    private String roleName;

    private String roleDescription;

    private String roleCode;
    //权限级别
    private String roleLevel;

    private String UserId;


}
