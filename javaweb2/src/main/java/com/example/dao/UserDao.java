package com.example.dao;

import com.example.Util.JDBCUtils;
import com.example.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库 User表的类
 */
public class UserDao {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 登录方法
     * @param loginUser  只有用户名和密码
     * @return y用户全部数据
     */
    public User login(User loginUser){


        //1.编写sql
        String sql = "select * from user where username = ? and password = ?";
        //2.调用query方法


        try {
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
