package com.day05.jdbc0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account表 删除一条记录
 *  执行DDL语句
 */
public class ex4demo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      //  String sql="delete from account where id = 3";
   // DDL 语句

        String sql="create table stu (id int,name varchar (20))";
        String url="jdbc:mysql://localhost:3306/db3?serverTimezone=Asia/Shanghai";

        try(
                Connection conn = DriverManager.getConnection(url,"root","root");
                Statement st = conn.createStatement();
        ){
            int count = st.executeUpdate(sql);
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
