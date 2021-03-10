package com.day06.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0 数据库连接池
 */
public class ex1demo {
    public static void main(String[] args) throws SQLException {
    // 先配置文件

   // 获取DataSource，使用默认配置 ，创建数据库连接池对象
        DataSource ds=new ComboPooledDataSource();

      //  使用对应 配置名称的 datasource
    //    DataSource ds=new ComboPooledDataSource("otherc3p0");

      //  获取连接
      //  Connection conn = ds.getConnection();

        for (int i = 1; i <=11 ; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
            if(i==5)
                conn.close();

        }

      //  System.out.println(conn);

    }
}
