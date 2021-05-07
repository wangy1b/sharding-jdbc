package com.wyb.shardingjdbc.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.*;

public class BirthdayAlgorithm implements PreciseShardingAlgorithm<Date>{
    List<Date> dateList = new ArrayList<>();

    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2020,1,1,0,0,0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2021,1,1,0,0,0);
        // Calendar calendar3 = Calendar.getInstance();
        // calendar3.set(2022,1,1,0,0,0);
        dateList.add(calendar1.getTime());
        dateList.add(calendar2.getTime());
        // dateList.add(calendar3.getTime());
    }

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {
        // 获取属性数据库的值
        Date date = preciseShardingValue.getValue();
        // 获取数据源的名称信息列表
        Iterator<String> iterator = collection.iterator();
        String target = null;
        for (Date s : dateList) {
            target = iterator.next();
            // 如果数据万余指定日期直接返回
            if (date.before(s)) {
                break;
            }
        }

        return target; // 最后返回的是ds0,ds1
    }
}
