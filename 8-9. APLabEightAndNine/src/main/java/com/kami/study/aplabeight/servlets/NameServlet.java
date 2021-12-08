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

@WebServlet(name = "NameServlet", urlPatterns = "/nameServlet")
public class NameServlet extends HttpServlet {

    @EJB
//    MyMainBean myMainBean;
    MySecondaryBean mySecondaryBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name;
        try {
            name = request.getParameter("name");
//            if (!name.isEmpty()) {
//                ArrayList<Employee> list = myMainBean.updateAndGetListByName(name);
//                StringBuilder table = new StringBuilder("");
//                response.setContentType("text/html");
//                for (Employee emp : list) {
//                    if (emp.getFirstname().equals(name)) {
//                        table.append(emp.toString())
//                                .append("\n")
//                                .append("\n");
//                    }
//                }

            String table = mySecondaryBean.getByName(name);

            request.setAttribute("table", table);
            request.getRequestDispatcher("views/list.jsp").forward(request, response);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("views/errorName.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
