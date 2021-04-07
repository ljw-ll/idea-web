package com.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/ex4")
public class ex4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("get");
        System.out.println(username);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("utf-8");

       /*String username = req.getParameter("username");
       System.out.println("post");
        System.out.println(username);*/

       // String[] hobbys = req.getParameterValues("hobby");
      /*  for (String hobby: hobbys){
            System.out.println(hobby);
        }*/

     //   Enumeration<String> parameterNames = req.getParameterNames();
       /* while(parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s);
            String val = req.getParameter(s);
            System.out.println(val);
            System.out.println("--------------------");
        }*/

        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            String[] vals = parameterMap.get(name);
            for (String val : vals) {
                System.out.println(val);
            }
            System.out.println("---------------");
        }


    }
}