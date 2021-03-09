package com.day05.jdbc0;

import java.sql.*;

/**
 * account表 修改记录
 */
public class ex3demo {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql="update account set balance = 1500 where id = 3";


        //   String url="jdbc:mysql://localhost:3306/db3?serverTimezone=Asia/Shanghai";
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
