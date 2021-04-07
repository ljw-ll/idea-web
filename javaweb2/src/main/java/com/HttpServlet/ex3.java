package com.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 获取请求体数据
 * 请求体数据 只有post可以发送
 */
@WebServlet("/ex3")
public class ex3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ex3被访问了......");
        Object msg = req.getAttribute("msg");
        System.out.println(msg);
        BufferedReader reader = req.getReader();
        String line=null;
        while((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }
}