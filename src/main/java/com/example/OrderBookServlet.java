package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/OrderBookServlet")
public class OrderBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            PrintWriter out = response.getWriter();

            String dateString = request.getParameter("date");
            String timeString = request.getParameter("time");
            String uid = (String) session.getAttribute("username");
            Integer pid = Integer.parseInt(request.getParameter("pid"));
            String address = request.getParameter("address");
            String dateTimeString = dateString + " " + timeString;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDateTime = dateFormat.parse(dateTimeString);
            Timestamp eventTime = new Timestamp(parsedDateTime.getTime());

            LocalDateTime todayDateTime = LocalDateTime.now();
            Timestamp bookedDate = Timestamp.valueOf(todayDateTime);

            // JDBC Connection
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "vivek597", "nakka597")) {
                // Prepare and execute the SQL statement
                try (PreparedStatement ps = conn.prepareStatement("INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?)")) {
                    ps.setString(1, uid);
                    ps.setInt(2, pid);
                    ps.setTimestamp(3, bookedDate);
                    ps.setDate(4, new java.sql.Date(parsedDateTime.getTime()));
                    ps.setTimestamp(5, eventTime);
                    ps.setString(6, address);

                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected > 0) {
                        out.println("<h1>Order Success</h1>");
                    } else {
                        out.println("<h1>Failed to insert order</h1>");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException | ParseException | NumberFormatException e) {
            e.printStackTrace();
            // Log the exception or provide a meaningful error message to the user
            response.getWriter().println("<h1>Error: " + e.getMessage() + e.getCause() + "</h1>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
