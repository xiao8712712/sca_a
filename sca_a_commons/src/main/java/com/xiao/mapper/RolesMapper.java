package com.xiao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.entiy.Roles;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface RolesMapper extends BaseMapper<Roles> {

    Set<String> getRoelesName(String userId);
}
