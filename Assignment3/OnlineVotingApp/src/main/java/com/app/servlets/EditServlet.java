package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/votingdb",
                    "root",
                    "Sujit@11");

            PreparedStatement pst =
                    con.prepareStatement(
                    "SELECT * FROM candidates WHERE id=?");

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            PrintWriter out = response.getWriter();

            if(rs.next()) {

                out.println("<h2>Candidate Details</h2>");

                out.println("<form>");

                out.println("ID : ");
                out.println("<input type='text' value='"
                        + rs.getInt("id")
                        + "' readonly><br><br>");

                out.println("Name : ");
                out.println("<input type='text' value='"
                        + rs.getString("name")
                        + "'><br><br>");

                out.println("Party : ");
                out.println("<input type='text' value='"
                        + rs.getString("party")
                        + "'><br><br>");

                out.println("</form>");
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}