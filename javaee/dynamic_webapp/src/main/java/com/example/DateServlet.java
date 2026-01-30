package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class DateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        LocalDateTime curr = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = curr.format(formatter);

         out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Current Date</title></head>");
        out.println("<body>");
        out.println("<h1>Current Date and Time</h1>");
        out.println("<p>The current date and time is: <strong>" + formattedDate + "</strong></p>");
        out.println("<a href='index.jsp'>Go Back</a>");
        out.println("</body>");
        out.println("</html>");

    }
}
