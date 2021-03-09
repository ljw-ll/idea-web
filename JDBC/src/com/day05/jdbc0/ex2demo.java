package com.day05.jdbc0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account表 添加一条记录 insert 语句
 */
public class ex2demo {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

     //   String sql="insert into account values(null,'王五',3000)";
        String sql  = "update account set balance = 1500 where id = 3";

        String url="jdbc:mysql://localhost:3306/db3?serverTimezone=Asia/Shanghai";
        try(
                Connection conn = DriverManager.getConnection(url,"root","root");
                Statement st = conn.createStatement()
        ){
            int count = st.executeUpdate(sql);
            System.out.println(count);
            if(count>0) System.out.println("添加成功");
            else System.out.println("添加失败");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
