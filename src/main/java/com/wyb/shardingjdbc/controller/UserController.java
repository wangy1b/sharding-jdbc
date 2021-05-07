package com.wyb.shardingjdbc.controller;

import com.wyb.shardingjdbc.entity.User;
import com.wyb.shardingjdbc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/slave")
    public String insert() {
        User user = new User();
        user.setNickname("zhangsan" + new Random().nextInt());
        user.setPassword("12345" );
        user.setAge(new Random().nextInt(80));
        user.setSex(new Random().nextInt(1));
        user.setBirthday("1988-12-03");
        userMapper.addUser(user);
        return "success";
    }
    @GetMapping("listuser")
    public List<User> listuser() {
        return userMapper.findUsers();
    }
}
