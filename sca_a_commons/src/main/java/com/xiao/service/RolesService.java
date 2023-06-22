package com.xiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiao.entiy.Roles;

import java.util.Set;


public interface RolesService extends IService<Roles> {
    Set<String> getRoleName(String userId);
}
