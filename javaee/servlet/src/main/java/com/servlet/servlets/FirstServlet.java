package com.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FirstServlet implements Servlet {
    private ServletConfig serveletConfig;


    @Override
    public void init(ServletConfig arg0) throws ServletException {
        this.serveletConfig = arg0;
        System.out.println("Servlet initialized!"); 
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h1>Hello World!</h1>");
        out.println("<p>Today is: " + new Date() + "</p>");
        out.println("</body></html>");

    }

    @Override
    public void destroy() {
        System.out.println("Servlet destroyed!");
        
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.serveletConfig;
    }

    @Override
    public String getServletInfo() {
        return "Servlet example";
    }
    
}