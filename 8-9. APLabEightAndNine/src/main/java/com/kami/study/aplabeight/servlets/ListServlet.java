package com.kami.study.aplabeight.servlets;

import com.kami.study.aplabeight.beans.MyMainBean;
import com.kami.study.aplabeight.beans.MySecondaryBean;
import com.kami.study.aplabeight.entities.Employee;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListServlet", urlPatterns = "/listServlet")
public class ListServlet extends HttpServlet {

    @EJB
//    MyMainBean myMainBean;
    MySecondaryBean mySecondaryBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String table = mySecondaryBean.getAllEmps();

//        ArrayList<Employee> list = myMainBean.updateAndGetList();
//        StringBuilder table = new StringBuilder("");
//        response.setContentType("text/html");
//        for (Employee emp : list) {
//            table.append(emp.toString())
//                    .append("\n")
//                    .append("\n");
//        }
        request.setAttribute("table", table);
        request.getRequestDispatcher("views/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
