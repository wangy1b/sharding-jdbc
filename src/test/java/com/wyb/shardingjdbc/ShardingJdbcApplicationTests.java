package com.wyb.shardingjdbc;

import com.wyb.shardingjdbc.entity.User;
import com.wyb.shardingjdbc.entity.UserOrder;
import com.wyb.shardingjdbc.mapper.UserMapper;
import com.wyb.shardingjdbc.mapper.UserOrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class ShardingJdbcApplicationTests {

	// @Autowired
	// private UserMapper userMapper;
	// @Test
	// void contextLoads() throws ParseException {
	// 	User user = new User();
	// 	user.setNickname("user_" + new Random().nextInt(100));
	// 	user.setPassword("12345" );
	// 	user.setAge(new Random().nextInt(80));
	// 	user.setSex(new Random().nextInt(1));
	// 	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
	// 	// Date date = simpleDateFormat.parse("1999-05-09");
	// 	Date date = simpleDateFormat.parse("2020-05-09");
	// 	user.setBirthday(date);
	// 	userMapper.addUser(user);
	// 	System.out.println(user.getId());
    //
	// }

    @Autowired
    private UserOrderMapper userOrderMapper;
    @Test
    void ym() throws ParseException {
        UserOrder order = new UserOrder();
        order.setUser_id(new Random().nextInt(100));
        order.setOrde_rnumber("12345" );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse("2020-05-09");
        order.setCreate_time(date);
        String[] yms = {"202101","202102","202103","202201","202202","202203"};
        // order.setYearmonth(yms[new Random().nextInt(6)]);
        order.setYearmonth(yms[0]);
        userOrderMapper.addOrder(order);
    }

    @Test
    void cnt(){
        System.out.println(userOrderMapper.countOrders());
    }

    @Test
    void selectPage(){
        System.out.println(userOrderMapper.listOrdersPage(0));
        System.out.println("==========1=============");
        System.out.println(userOrderMapper.listOrdersPage(10));
        System.out.println("==========2=============");
        System.out.println(userOrderMapper.listOrdersPage(20));

    }

}
