/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Assignment2;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riya vesuwala
 */
@WebServlet(name = "Registration", urlPatterns = {"/Registration"})
public class Registration extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registration at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

    HttpSession session = request.getSession();

    String sessionCaptcha = (String) session.getAttribute("captcha");
    String userCaptcha = request.getParameter("usercaptcha");

    if (sessionCaptcha == null || userCaptcha == null ||
        !userCaptcha.equals(sessionCaptcha)) {

        response.sendRedirect("CaptchaGenerator");
        return;
    }

    session.removeAttribute("captcha");

    try (Connection con = DBUtill.getConnection()) {

        String sql = "INSERT INTO user_master " +
                "(username,login_id,password,password_question,password_answer,email,phone,address,city,state,country,pin) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, request.getParameter("username"));
        pst.setString(2, request.getParameter("loginid"));
        pst.setString(3, request.getParameter("password"));
        pst.setString(4, request.getParameter("question"));
        pst.setString(5, request.getParameter("answer"));
        pst.setString(6, request.getParameter("email"));
        pst.setString(7, request.getParameter("phone"));
        pst.setString(8, request.getParameter("address"));
        pst.setString(9, request.getParameter("city"));
        pst.setString(10, request.getParameter("state"));
        pst.setString(11, request.getParameter("country"));
        pst.setString(12, request.getParameter("pin"));

        int i = pst.executeUpdate();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        if (i > 0) {
            pw.println("<h1>User Registered Successfully</h1>");
        } else {
            pw.println("<h1>Registration Failed</h1>");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
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
