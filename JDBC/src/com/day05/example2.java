package com.day05;

import com.day05.jdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 */
public class example2 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        try{
           conn= JDBCUtils.getConnection();
           // 开启事务
           conn.setAutoCommit(false);

           String sql2="update account set balance=balance-? where id=?";
           String sql3="update account set balance=balance+? where id=?";
            pst1 = conn.prepareStatement(sql2);
            pst2 = conn.prepareStatement(sql3);
            pst1.setDouble(1,500);
            pst1.setInt(2,1);

            pst2.setDouble(1,500);
            pst2.setInt(2,2);

            pst1.executeUpdate();
            pst2.executeUpdate();

            conn.commit();

        } catch (Exception e) {
            try {
                if(conn!=null) conn.rollback();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pst1,conn);
            JDBCUtils.close(pst2,null);
        }
    }
}
