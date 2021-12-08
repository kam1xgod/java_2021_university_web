package com.kami.study.aplabseventhtasktwosecondtry.servlets;

import com.kami.study.aplabseventhtasktwosecondtry.beans.MyMainBean;
import com.kami.study.aplabseventhtasktwosecondtry.entities.Employee;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.ejb.EJB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "NameServlet", urlPatterns = "/nameServlet")
public class NameServlet extends HttpServlet {

    @EJB
    MyMainBean myMainBean = new MyMainBean();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name;
        try {
            name = request.getParameter("name");
            if (!name.isEmpty()) {
                ArrayList<Employee> list = myMainBean.updateAndGetListByName(name);
                StringBuilder table = new StringBuilder("");
                response.setContentType("text/html");
                for (Employee emp : list) {
                    if (emp.getFirstname().equals(name)) {
                        table.append(emp.toString())
                                .append("\n")
                                .append("\n");
                    }
                }
                request.setAttribute("table", table);
                request.getRequestDispatcher("views/name.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("views/errorName.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
