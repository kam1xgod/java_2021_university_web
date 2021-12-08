package com.kami.study.aplabseventhtasktwosecondtry.servlets;

import com.kami.study.aplabseventhtasktwosecondtry.beans.MyMainBean;
import com.kami.study.aplabseventhtasktwosecondtry.beans.MyMainBeanLocal;
import com.kami.study.aplabseventhtasktwosecondtry.beans.MyMainBeanRemote;
import com.kami.study.aplabseventhtasktwosecondtry.entities.Employee;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


import jakarta.ejb.EJB;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "ListServlet", urlPatterns = "/listServlet")
public class ListServlet extends HttpServlet {

    @EJB
    MyMainBean myMainBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        MyMainBean myMainBean = null;
//        try {
//            myMainBean = (MyMainBean) new InitialContext().lookup("java:comp/env/MyMainBean");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }

        try {

            ArrayList<Employee> list = myMainBean.updateAndGetList();
            StringBuilder table = new StringBuilder("");
            response.setContentType("text/html");
            for (Employee emp : list) {
                table.append(emp.toString())
                        .append("\n")
                        .append("\n");
            }
            request.setAttribute("table", table);
            request.getRequestDispatcher("views/list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
