package client;

import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import jms.JMSProducer;

public class bookservlet extends HttpServlet {

    @EJB
    private JMSProducer producer;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        producer.sendMessage(id);

        res.getWriter().println("Message Sent to Queue!");
    }
}