package com.wyb.shardingjdbc.entity;


import lombok.Data;

import java.util.Date;

@Data
public class User {
    // 主键
    private Long id;
    // 用户名
    private String nickname;
    // 密码
    private String password;
    // 年龄
    private Integer age;
    /**
     * 性别 0代表男 1代表女
     */
    private Integer sex;

    private Date birthday;
}
