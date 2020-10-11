package com.cs.servlet;

import com.cs.entity.User;
import com.cs.service.impl.UserServiceImpl;
import com.cs.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm=request.getParameter("comm");
        if(comm.equals("list")) {
            String pageNO = request.getParameter("indexno");
            if (pageNO == null || pageNO == "") {
                pageNO = "1";
            }
            int pno = Integer.parseInt(pageNO);
            UserServiceImpl usi = new UserServiceImpl();
            PageSupport ps = new PageSupport();
            ps.setCurrentPageNo(pno);
            ps.setPageSize(3);
            try {
                ps.setTotalCount(usi.findByCountUser());
                List<User> list = usi.findByPageUserInfo(ps.getCurrentPageNo(), ps.getPageSize());
                if (list.size() > 0 && list != null) {
                    request.getSession().setAttribute("lists", list);
                    request.getSession().setAttribute("ps", ps);
                    response.sendRedirect("list.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(comm.equals("query")){
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            //创建UserDaoImpl对象
            UserServiceImpl usi=new UserServiceImpl();
            //2接收用户提交过的数据
            String id=request.getParameter("id");
            int ids=Integer.parseInt(id);
            //做查看功能
            if(comm.equals("query")) {
                User us= null;
                try {
                    us = usi.findByUserIDi(ids);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (us != null) {
                    request.setAttribute("us", us);
                    request.getRequestDispatcher("query.jsp").forward(request, response);
                } else {

                }
            }
        }
        if(comm.equals("del")){
            UserServiceImpl usi=new UserServiceImpl();
            String id=request.getParameter("id");
            int ids=Integer.parseInt(id);
            boolean flang= false;
            try {
                flang = usi.delUser(ids);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(flang){
                response.sendRedirect("show.jsp");
            }
        }
        if(comm.equals("update")){
            UserServiceImpl usi=new UserServiceImpl();
            String name=request.getParameter("username");
            String pass=request.getParameter("password");
            String sex=request.getParameter("sex");
            String id=request.getParameter("id");
            int ids=Integer.parseInt(id);
            User us=new User();
            us.setId(ids);
            us.setUsername(name);
            us.setPassword(pass);
            us.setSex(sex);
            boolean flang= false;
            try {
                flang = usi.updateUser(us);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(flang){
                response.sendRedirect("show.jsp");
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
    }
}
