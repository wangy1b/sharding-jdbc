package com.wyb.shardingjdbc.mapper;

import com.wyb.shardingjdbc.entity.UserOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserOrderMapper {
    @Insert("insert into ksd_user_order(user_id,orde_rnumber,create_time,yearmonth) " +
            "values(#{user_id},#{orde_rnumber},#{create_time},#{yearmonth})")
    @Options(useGeneratedKeys = true,keyColumn = "order_id",keyProperty = "order_id")
    void addOrder(UserOrder userOrder);

    @Select("select * from ksd_user_order")
    List<UserOrder> listOrders();

    @Select("select * from ksd_user_order limit ${pageNo},10")
    List<UserOrder> listOrdersPage(Integer pageNo);


    @Select("select count(1) from ksd_user_order")
    int countOrders();

}
