package com.day06.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.day05.jdbcUtils.JDBCUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 */
public class DruidUtils {
   private  static DataSource ds;
   static {
       Properties pro = new Properties();
       try {
           pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
           ds = DruidDataSourceFactory.createDataSource(pro);

       } catch (IOException e) {
           e.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
       /**
        * 获取连接
        */
       public  static Connection getConnection() throws SQLException {
           return ds.getConnection();
       }

    /**
     * 释放资源
     */
    public  static  void close(Statement st,Connection conn){
        close(null,st,conn);
      /*  if(st!=null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/
    }


    public  static  void close(ResultSet rs,Statement st, Connection conn){

        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    /**
     * 获取连接池
     */
    public  static  DataSource getDataSource(){
        return  ds;
    }

}
