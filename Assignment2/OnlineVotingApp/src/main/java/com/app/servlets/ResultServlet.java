package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String URL =
            "jdbc:mysql://localhost:3306/votingdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Sujit@11";

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            Statement stmt = con.createStatement();

            ResultSet rs =
                    stmt.executeQuery("SELECT * FROM candidates");

            PrintWriter out = response.getWriter();

            out.println("<html><body>");
            out.println("<h2>Candidate List</h2>");

            out.println("<table border='1' cellpadding='5'>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Party</th>");
            out.println("</tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("party") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(
                    "<h3>Error : " + e.getMessage() + "</h3>");
        }
    }
}