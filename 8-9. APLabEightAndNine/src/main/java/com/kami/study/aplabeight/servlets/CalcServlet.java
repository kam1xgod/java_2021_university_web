package com.kami.study.aplabeight.servlets;

import com.kami.study.aplabeight.beans.CalcBean;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalcServlet", urlPatterns = "/CalcServlet")
public class CalcServlet extends HttpServlet {
    @EJB
    CalcBean calculatorBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        double x = 0;
        double y = 0;
        double result = 0;
        String op = "";
        try {
            x = Double.parseDouble(request.getParameter("x"));
            y = Double.parseDouble(request.getParameter("y"));
            op = request.getParameter("op");

            if (request.getParameter("submit").equals("write")) {
                if (x == 0 && y == 0) {
                    //todo: some jsp with error.
                }

                calculatorBean.setMemory(x + "," + y);
            } else if (request.getParameter("submit").equals("read")) {
                x = Double.parseDouble(calculatorBean.getMemory().split(",")[0]);
                y = Double.parseDouble(calculatorBean.getMemory().split(",")[1]);
            } else {
                switch (op) {
                    case "+":
                        result = calculatorBean.add(x, y);
                        break;
                    case "-":
                        result = calculatorBean.subtract(x, y);
                        break;
                    case "*":
                        result = calculatorBean.multiply(x, y);
                        break;
                    case "/":
                        if (y == 0) {
                            //todo: some jsp with error.
                            break;
                        }
                        result = calculatorBean.divide(x, y);
                        break;
                    default:
                        //todo: some jsp with error.
                        break;
                }
            }


            request.setAttribute("x", x);
            request.setAttribute("y", y);
            request.setAttribute("memory", calculatorBean.getMemory());
            request.setAttribute("result", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/calc.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
