package com.geekymv.springcloud.mapper;

import com.geekymv.springcloud.model.Permission;

import java.util.List;

public interface PermissionMapper {

    List<Permission> selectByUserId(Long userId);
}
