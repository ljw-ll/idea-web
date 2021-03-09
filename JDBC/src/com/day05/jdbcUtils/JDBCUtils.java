package com.day05.jdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /**
     * 文件的读取，只需要读取一次即可拿到这些值。使用静态代码块
     */

    static{
        // 读取文件，获取值
        Properties pro=new Properties();

        try {

            // 获取src 下的文件 ，使用类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
      /*     URL res = classLoader.getResource("jdbc.properties");
           String path = res.getPath();
            pro.load(new FileReader(path));*/
            InputStream is= classLoader.getResourceAsStream("jdbc.properties");
            pro.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }

        url =pro.getProperty("url");
        user=pro.getProperty("user");
        password=pro.getProperty("password");
        driver=pro.getProperty("driver");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



    /**
     * 获取连接
     * @return  连接对象
     */
  public  static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(url,user,password);
  }

    /**
     * 释放资源
     * @param st
     * @param conn
     */
  public static  void close(Statement st,Connection conn){
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

    public static  void close(ResultSet rs, Statement st, Connection conn){
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
}
