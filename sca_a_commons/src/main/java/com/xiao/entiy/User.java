package com.xiao.entiy;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiao.base.BaseEntity.BaseEntity;
import lombok.Data;

@Data
@TableName("sys_user")
public class User extends BaseEntity {

    private String userName;

    //密码拼接验证码加密
    private String password;

    private String email;

    private String age;

    private String roles;

    //验证码
    private String salt;

    //单位编码
    private String unitCode;

    //一个多岗（表示此人有多个岗位编码）
    //岗位编码（由部门编码和职位编码构成  比如 001234 00表示单位  12代表部门编码  34代表职级  56表是这个部门这个的岗位的角色，角色不同 权限不同）
    private String postTypeCode;

    //部门编码
    private String  DepartmentCode;




}
