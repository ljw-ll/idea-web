package com.example.servlet;

import com.example.dao.UserDao;
import com.example.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

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