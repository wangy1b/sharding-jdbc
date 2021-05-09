package com.wyb.shardingjdbc.entity;

import java.util.Date;

public class UserOrder {
    private long order_id;
    private long user_id ;
    private String orde_rnumber;
    private Date create_time;
    private String yearmonth  ;

    public UserOrder() {
    }

    public UserOrder(long order_id, long user_id, String orde_rnumber, Date create_time, String yearmonth) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.orde_rnumber = orde_rnumber;
        this.create_time = create_time;
        this.yearmonth = yearmonth;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getOrde_rnumber() {
        return orde_rnumber;
    }

    public void setOrde_rnumber(String orde_rnumber) {
        this.orde_rnumber = orde_rnumber;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", orde_rnumber='" + orde_rnumber + '\'' +
                ", create_time=" + create_time +
                ", yearmonth='" + yearmonth + '\'' +
                '}';
    }
}
