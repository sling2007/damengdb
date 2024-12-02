package com.sling.demo.util;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * User: sunling
 * Date: 2024/11/29 11:33
 * Description:
 **/
public class DamonDBDruidPoolUtil {

    private static DataSource dataSource;

    static {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:dm://localhost:5236");
        druidDataSource.setUsername("HMNTECH");
        druidDataSource.setPassword("Marine.123");

        // 配置初始化大小、最小、最大
        druidDataSource.setInitialSize(5);
        druidDataSource.setMinIdle(5);
        druidDataSource.setMaxActive(20);

        // 配置获取连接等待超时的时间
        druidDataSource.setMaxWait(60000);

        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);

        // 配置一个连接在池中最小生存的时间，单位是毫秒
        druidDataSource.setMinEvictableIdleTimeMillis(300000);

        // 用来检测连接是否有效的sql，要求是一个查询语句
        // 注意：这里使用的是达梦数据库的语法，确保它是有效的
        druidDataSource.setValidationQuery("SELECT 1 FROM DUAL");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);

        // 打开PSCache，并且指定每个连接上PSCache的大小
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);

        // 配置监控统计拦截的filters，stat:监控统计、log4j：日志记录、slf4j：日志记录
        String filters = "stat";
        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dataSource = druidDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}