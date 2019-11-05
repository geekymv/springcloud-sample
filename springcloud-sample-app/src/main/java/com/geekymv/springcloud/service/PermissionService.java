package com.geekymv.springcloud.service;

import com.geekymv.springcloud.model.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> selectByUserId(Long userId);
}
