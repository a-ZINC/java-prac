package com.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class HttpServletEx extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello World HTTP Get!</h1>");
        out.println("<p>Today is: " + new Date() + "</p>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello World HTTP Post!</h1>");
        out.println("<p>Today is: " + new Date() + "</p>");
        out.println("</body></html>");
    }
}
