package com.example.test;

import com.example.dao.UserDao;
import com.example.domain.User;
import org.junit.Test;


public class UserDaoTest {
    @Test
    public  void testLogin(){
        User user=new User();
        user.setUsername("zhangsan");
        user.setPassword("123");

        UserDao dao=new UserDao();
        User loginUser = dao.login(user);
        System.out.println("-------------");
        System.out.println(loginUser);

    }

}
