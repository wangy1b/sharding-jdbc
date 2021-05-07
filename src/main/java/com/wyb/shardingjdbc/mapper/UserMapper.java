package com.wyb.shardingjdbc.mapper;

import com.wyb.shardingjdbc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Insert("insert into ksd_user(nickname,password,age,sex,birthday) values(#{nickname},#{password},#{age},#{sex},#{birthday})")
    void addUser(User user);

    @Select("select * from ksd_user")
    List<User> findUsers();
}
