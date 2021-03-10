package com.day06.jdbctemplate;

import com.day06.utils.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class ex1demo {
    public static void main(String[] args) {

        JdbcTemplate template=new JdbcTemplate(DruidUtils.getDataSource());

        String sql="update account set balance=1000 where id=?";
        int count = template.update(sql, 1);
        System.out.println(count);
    }
}
