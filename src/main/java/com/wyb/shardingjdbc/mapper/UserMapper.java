package com.wyb.shardingjdbc.mapper;

import com.wyb.shardingjdbc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into ksd_user(nickname,password,age,sex,birthday) values(#{nickname},#{password},#{age},#{sex},#{birthday})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void addUser(User user);

    @Select("select * from ksd_user")
    List<User> findUsers();
}
