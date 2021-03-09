package com.day05.jdbc0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ex1jdbc {
    public static void main(String[] args) throws Exception {

        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db3?serverTimezone=Asia/Shanghai";
     //   Connection conn = DriverManager.getConnection(url, "root", "root");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db3?serverTimezone=Asia/Shanghai", "root", "root");

        String sql="Update account set balance=700 where id=1";

        Statement st = conn.createStatement();
        int count=st.executeUpdate(sql);
        System.out.println(count);

        st.close();
        conn.close();


    }
}
