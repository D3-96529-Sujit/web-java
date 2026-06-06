package com.app.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("Email = " + email);
        System.out.println("Password = " + password);

        if ("admin@gmail.com".equals(email)
                && "admin123".equals(password)) {

            System.out.println("Login Success");
            response.sendRedirect("result");

        } else {

            System.out.println("Login Failed");
            response.getWriter().println("Invalid Login");
        }
    }
}