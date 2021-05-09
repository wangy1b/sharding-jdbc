package com.wyb.shardingjdbc.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.Date;

public class YearMonthShardingAlgorithm implements PreciseShardingAlgorithm<String> {
    private static final String SPLITER = "_";
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        String tableName = preciseShardingValue.getLogicTableName() + SPLITER + preciseShardingValue.getValue();
        System.out.println( "output: " + tableName);
        return tableName;
    }
}
