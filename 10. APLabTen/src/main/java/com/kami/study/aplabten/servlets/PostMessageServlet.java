package com.kami.study.aplabten.servlets;

import entities.MessagesEntity;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "PostMessageServlet", urlPatterns = "/PostMessageServlet")
public class PostMessageServlet extends HttpServlet {

    private MessagesEntity messageItem;

    @Resource(name = "java:ConnectionFactory")
    private QueueConnectionFactory cf;

    @Resource(mappedName = "java:/jms/queue/ExpiryQueue")
    private Queue queue;

    @Inject
    private JMSContext context;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String message = request.getParameter("message");
//        Timestamp timestamp = (Timestamp)
        //Date and Time with formatter. same in entity. I guess.

        if (message != null) {
            try {

                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                Timestamp sqlTime = new Timestamp(date.getTime());

                InitialContext ctx = new InitialContext();
                queue = (Queue) ctx.lookup("java:/jms/queue/ExpiryQueue");
                cf = (QueueConnectionFactory) ctx.lookup("/ConnectionFactory");
                QueueConnection connection = cf.createQueueConnection();
                QueueSession sessionQueue = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
                ObjectMessage mes = sessionQueue.createObjectMessage();
                MessageProducer messageProducer = sessionQueue.createProducer(queue);

                messageItem = new MessagesEntity();
                messageItem.setMessage(message);
                messageItem.setTime(sqlTime);

                // EntityTransaction transaction = entityManager.getTransaction();

                // MessagesEntity me = new MessagesEntity();
                // me.setMessage(message);
                // e.setTime(timestamp);

//                TextMessage mes = context.createTextMessage(message);
//                JMSProducer producer = context.createProducer();
//                producer.send(queue, mes);

                mes.setObject(messageItem);
                messageProducer.send(mes);
                messageProducer.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.getRequestDispatcher("postMessages.jsp").forward(request, response);
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
