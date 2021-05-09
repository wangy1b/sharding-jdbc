package com.wyb.shardingjdbc.service;

import com.wyb.shardingjdbc.entity.User;
import com.wyb.shardingjdbc.entity.UserOrder;
import com.wyb.shardingjdbc.mapper.UserMapper;
import com.wyb.shardingjdbc.mapper.UserOrderMapper;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserOderService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserOrderMapper userOrderMapper;

    // mybatis单独库的事务保证
    // @Transactional(rollbackFor = Exception.class)
    // 使用分布式事务 XA协议
    @ShardingTransactionType(TransactionType.XA)
    public int saveUserOrder(User user, UserOrder userOrder){
        userMapper.addUser(user);
        userOrder.setUser_id(user.getId());
        userOrderMapper.addOrder(userOrder);
        return 1;
    }
}
