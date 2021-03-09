package com.day05;

import com.day05.jdbcUtils.JDBCUtils;
import com.sun.jdi.connect.Connector;

import java.sql.*;
import java.util.Scanner;

/**
 * 练习：
 * 		* 需求：
 * 			1. 通过键盘录入用户名和密码
 * 			2. 判断用户是否登录成功
 */
public class example1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
         String username= in.nextLine();
         String password= in.nextLine();

        // boolean flag=new example1().login(username,password);
         boolean flag1=new example1().login2(username,password);
        if(flag1){
            //登录成功
            System.out.println("登录成功！");
        }else{
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 判断登录
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password){
         if (username==null||password==null){
             return false;
         }
        Connection conn=null;
        Statement st =null;
        ResultSet rs=null;
         //连接数据库
        try {
            conn = JDBCUtils.getConnection();
            String sql="select * from user where username='"+username+"'and password='"+password+"'";
            System.out.println(sql);
           st = conn.createStatement();
              rs= st.executeQuery(sql);
           // System.out.println();

             return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,st,conn);
        }


        return false;
    }

    /**
     * 判断登录 ,使用 prepareStatement
     * @param username
     * @param password
     * @return
     */
    public boolean login2(String username, String password){
        if (username==null||password==null){
            return false;
        }
        Connection conn=null;
        PreparedStatement pst =null;
        ResultSet rs=null;
        //连接数据库
        try {
            conn = JDBCUtils.getConnection();
            String sql="select * from user where username=? and password=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);

            rs= pst.executeQuery();
            // System.out.println();

            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pst,conn);
        }


        return false;
    }
}
