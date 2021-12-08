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

@WebServlet(name = "IdServlet", urlPatterns = "/idServlet")
public class IdServlet extends HttpServlet {

    @EJB
    MyMainBean myMainBean = new MyMainBean();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            if (id != 0) {
                ArrayList<Employee> list = myMainBean.updateAndGetListById(id);
                StringBuilder table = new StringBuilder("");
                response.setContentType("text/html");
                for (Employee emp : list) {
                    table.append(emp.toString())
                            .append("\n")
                            .append("\n");
                }
                request.setAttribute("table", table);
                request.getRequestDispatcher("views/id.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("views/errorID.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
