package com.geekymv.springcloud.service;

import com.geekymv.springcloud.mapper.UserMapper;
import com.geekymv.springcloud.model.Permission;
import com.geekymv.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        User tbUser = userMapper.getByUsername(username);
        if(tbUser == null) {
            throw new UsernameNotFoundException(username + "用户不存在");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (tbUser != null) {
            // 获取用户授权
            List<Permission> tbPermissions = permissionService.selectByUserId(tbUser.getId());

            // 声明用户授权
            tbPermissions.forEach(tbPermission -> {
                if (tbPermission != null && tbPermission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }

        // 由框架完成认证工作
        return new org.springframework.security.core.userdetails.User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
    }
}
