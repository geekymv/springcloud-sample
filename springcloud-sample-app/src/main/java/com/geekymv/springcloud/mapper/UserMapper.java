package com.geekymv.springcloud.mapper;

import com.geekymv.springcloud.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getByUsername(@Param("username") String username);
}
