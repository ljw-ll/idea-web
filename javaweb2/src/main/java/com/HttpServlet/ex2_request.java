package com.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * request 获取请求行数据
 *         获取请求头数据
 */

@WebServlet("/ex2_request")
public class ex2_request extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        // request 获取请求行数据
       // demo1(req);
        //request 获取请求头数据
        demo2(req);

    }
 /*
 * (*)String getHeader(String name):通过请求头的名称获取请求头的值
 * Enumeration<String> getHeaderNames():获取所有的请求头名称
 */
    private void demo2(HttpServletRequest req) {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();

            String val = req.getHeader(name);
            System.out.println(name + "--> " + val);
        }
        System.out.println("-----------");
        String agent = req.getHeader("user-agent");
        if (agent.contains("Chrome")) {
            System.out.println("谷歌来啦。。。");
        } else {
            System.out.println("其他浏览器");
        }

    }

    /*
      1. 获取请求方式 ：GET
                  * String getMethod()
              2. (*)获取虚拟目录：/day14
                  * String getContextPath()
              3. 获取Servlet路径: /demo1
                  * String getServletPath()
              4. 获取get方式请求参数：name=zhangsan
                  * String getQueryString()
              5. (*)获取请求URI：/day14/demo1
                  * String getRequestURI():		/day14/demo1
                  * StringBuffer getRequestURL()  :http://localhost/day14/demo1
              6. 获取协议及版本：HTTP/1.1
                  * String getProtocol()
              7. 获取客户机的IP地址：
                  * String getRemoteAddr()
       */
    private void demo1(HttpServletRequest req) {
        //获取请求方式 ：GET
        String method = req.getMethod();
        System.out.println(method);
        // (*)获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        // 获取Servlet 路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        // 获取get方式请求参数：name=zhangsan
        String queryString = req.getQueryString();
        System.out.println(queryString);
        //(*)获取请求URI：/day14/demo1
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);

        //获取协议及版本：HTTP/1.1
        String protocol = req.getProtocol();
        System.out.println(protocol);

        //获取客户机的IP地址：
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}