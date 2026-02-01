package com.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/generic-servlet")
public class GenericServletEx extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello World Generic!</h1>");
        out.println("<p>Today is: " + new Date() + "</p>");
        out.println("</body></html>");
    }

    
    
}
