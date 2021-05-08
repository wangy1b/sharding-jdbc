package com.wyb.shardingjdbc.controller;

import com.wyb.shardingjdbc.entity.User;
import com.wyb.shardingjdbc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController  {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/save")
    public String insert() throws ParseException {
        User user = new User();
        user.setNickname("user_" + new Random().nextInt());
        user.setPassword("12345" );
        user.setAge(new Random().nextInt(80));
        user.setSex(new Random().nextInt(1));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse("1988-12-03");
        user.setBirthday(date);
        userMapper.addUser(user);
        return "success";
    }
    @GetMapping("/listuser")
    public List<User> listuser() {
        return userMapper.findUsers();
    }
}
