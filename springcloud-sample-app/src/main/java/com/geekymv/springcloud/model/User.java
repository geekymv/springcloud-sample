package com.geekymv.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    private Long id;

    private String username;
    private String password;
    private String phone;
    private String email;

    private Date created;
    private Date updated;

}
