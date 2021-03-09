package com.day05.jdbc1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class example {
    public static void main(String[] args) {
        List<Emp> list=findAll();
        for (Emp emp : list) {
            System.out.println(emp);
        }
       // System.out.println(list);
    }
    /**
     * 查询所有emp对象
     * @return
     */
    public static List<Emp> findAll(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql="select * from emp ";
        String url="jdbc:mysql://localhost:3306/db3?serverTimezone=Asia/Shanghai";
        List<Emp> list=null;
        try(
                Connection conn = DriverManager.getConnection(url, "root", "root");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
        ){
            Emp emp=null;
            list=new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp=new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBouns(bonus);
                emp.setDept_id(dept_id);

                list.add(emp);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
