package com.day06.druid;

import com.alibaba.druid.util.JdbcUtils;
import com.day06.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用druid 的 自定义工具类
 */
public class ex2demo {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pst =null;
        try {
           conn = DruidUtils.getConnection();
            String sql="insert into account values(null,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,"王六");
            pst.setDouble(2,5000);

           int count= pst.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtils.close(pst,conn);
        }
    }
}
