package com.kami.study.aplabten.servlets;

import com.kami.study.aplabten.beans.MessageEntityFacade;
import com.kami.study.aplabten.beans.MessageSessionBean;
import entities.MessagesEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ListMessagesServlet", urlPatterns = "/ListMessagesServlet")
public class ListMessagesServlet extends HttpServlet {

    @EJB
    private MessageSessionBean messageSessionBean;
    @EJB
    private MessageEntityFacade messageEntityFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        StringBuilder messagesBuilder = new StringBuilder("");
        try (PrintWriter out = response.getWriter()) {
            List messages = messageEntityFacade.findAll();
            for (Iterator i = messages.iterator(); i.hasNext();) {
                MessagesEntity elem = (MessagesEntity) i.next();
                messagesBuilder.append(elem.toString());
            }
        }

        request.setAttribute("table", messagesBuilder.toString());
        request.getRequestDispatcher("listMessages.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
