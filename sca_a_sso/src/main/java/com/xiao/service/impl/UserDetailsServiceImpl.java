package com.xiao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiao.entiy.Roles;
import com.xiao.entiy.User;
import com.xiao.mapper.RolesMapper;
import com.xiao.mapper.UserMapper;
import com.xiao.service.RolesService;
import com.xiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RolesService rolesService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper name = new QueryWrapper<User>().eq("user_name", username);
        User user = (User) userService.getOne(name);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        //获取权限
        QueryWrapper Roels = new QueryWrapper<Roles>().eq("user_id", user.getId());
        Set<String> rolesList = rolesService.getRoleName(user.getId());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthorities(rolesList));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<String> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
    }
}
