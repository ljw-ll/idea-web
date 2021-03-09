package com.day05.jdbc1;

import java.sql.*;

public class ex1demo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //   String sql="insert into account values(null,'王五',3000)";
        String sql  = "select * from account";

        String url="jdbc:mysql://localhost:3306/db3?serverTimezone=Asia/Shanghai";
        try(
                Connection conn = DriverManager.getConnection(url,"root","root");
                Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(sql);
        ){
             while (rs.next()){
                  int id = rs.getInt(1);
                 String name = rs.getString("name");
                 double balance = rs.getDouble(3);
                 System.out.println(id+" "+name+" "+balance);
             }




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
