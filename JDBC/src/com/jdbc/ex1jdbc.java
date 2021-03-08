package com.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class ex1jdbc {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8";
       Connection conn = DriverManager.getConnection(url, "root", "root");
    //    Connection conn = DriverManager.getConnection("jdbc:mysql:3306/db3", "root", "root");

        String sql="Update account set balance=600 where id=1";

        Statement st = conn.createStatement();
        int count=st.executeUpdate(sql);
        System.out.println(count);

        st.close();
        conn.close();


    }
}
