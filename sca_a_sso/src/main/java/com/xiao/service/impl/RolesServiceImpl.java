package com.xiao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiao.entiy.Roles;
import com.xiao.mapper.RolesMapper;
import com.xiao.service.RolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements RolesService {
    @Resource
    private RolesMapper mapper;

    @Override
    public Set<String> getRoleName(String userId) {
        return mapper.getRoelesName(userId);
    }
}
