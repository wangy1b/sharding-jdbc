package com.wyb.shardingjdbc.controller;

import com.wyb.shardingjdbc.entity.UserOrder;
import com.wyb.shardingjdbc.mapper.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/order")
public class UserOrderController {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @GetMapping("/addorder")
    public String addOrder() throws ParseException {
        UserOrder order = new UserOrder();
        order.setUser_id(new Random().nextInt(100));
        order.setOrde_rnumber("12345" );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        // Date date = simpleDateFormat.parse("1999-05-09");
        Date date = simpleDateFormat.parse("2020-05-09");
        order.setCreate_time(date);
        String[] yms = {"202101","202102","202103","202201","202202","202203"};
        order.setYearmonth(yms[new Random().nextInt(6)]);
        userOrderMapper.addOrder(order);
        return "success";
    }

    @GetMapping("/listorders")
    public List<UserOrder> listOrders() {
        return userOrderMapper.listOrders();
    }



}
