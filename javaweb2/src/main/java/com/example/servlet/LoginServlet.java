package com.example.servlet;

import com.example.dao.UserDao;
import com.example.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        User user=new User();
//        user.setUsername(username);
//        user.setPassword(password);
//
//        User loginUser = new UserDao().login(user);
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user=new User();

        // 使用BeanUtils 封装对象
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        User loginUser = new UserDao().login(user);
        if(loginUser==null) {
            //登录失败
            req.getRequestDispatcher("/FailServlet").forward(req,resp);
        }else {
            //
            req.setAttribute("user",loginUser);
            req.getRequestDispatcher("/SuccessServlet").forward(req,resp);

        }
    }
}