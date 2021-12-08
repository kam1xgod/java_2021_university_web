package com.kami.study.aplabeight.servlets;

import com.kami.study.aplabeight.beans.MyMainBean;
import com.kami.study.aplabeight.beans.MySecondaryBean;
import com.kami.study.aplabeight.entities.Employee;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "IdServlet", urlPatterns = "/idServlet")
public class IdServlet extends HttpServlet {

    @EJB
//    MyMainBean myMainBean;
    MySecondaryBean mySecondaryBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
//            if (id != 0) {
//                ArrayList<Employee> list = myMainBean.updateAndGetListById(id);
//                StringBuilder table = new StringBuilder("");
//                response.setContentType("text/html");
//                for (Employee emp : list) {
//                    table.append(emp.toString())
//                            .append("\n")
//                            .append("\n");

            String table = mySecondaryBean.getById(id);

            request.setAttribute("table", table);
            request.getRequestDispatcher("views/list.jsp").forward(request, response);
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("views/errorID.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
