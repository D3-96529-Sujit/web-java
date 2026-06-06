package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String URL =
            "jdbc:mysql://localhost:3306/votingdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Sujit@11";

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            String sql =
                "INSERT INTO users(first_name,last_name,email,password) VALUES(?,?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, email);
            pst.setString(4, password);

            int count = pst.executeUpdate();

            PrintWriter out = response.getWriter();

            if (count > 0) {
                out.println("<h2>Registration Successful!</h2>");
            } else {
                out.println("<h2>Registration Failed!</h2>");
            }

            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();

            PrintWriter out = response.getWriter();
            out.println("<h3>Error : " + e.getMessage() + "</h3>");
        }
    }
}