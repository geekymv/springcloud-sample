package com.geekymv.springcloud.service.impl;

import com.geekymv.springcloud.mapper.PermissionMapper;
import com.geekymv.springcloud.model.Permission;
import com.geekymv.springcloud.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> selectByUserId(Long userId) {
        return permissionMapper.selectByUserId(userId);
    }
}
