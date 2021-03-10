package com.day06.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class ex1demo {
    public static void main(String[] args) throws Exception {

        Properties pro=new Properties();
        InputStream is = ex1demo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);

        Connection conn = dataSource.getConnection();
        System.out.println(conn);

    }
}
