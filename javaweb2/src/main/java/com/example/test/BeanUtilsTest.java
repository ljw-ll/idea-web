package com.example.test;


import com.example.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void test()  {
        User user=new User();

        try {
            // 对setusername()的 属性进行修改， 而不是成员变量 直接修改
            BeanUtils.setProperty(user,"username","admin");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
