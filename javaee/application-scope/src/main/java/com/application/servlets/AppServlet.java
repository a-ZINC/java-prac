package com.application.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AppServlet extends HttpServlet {
    private ServletConfig servletConfig;
    private ServletContext servletContext;
    

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        this.servletContext = config.getServletContext();
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
       final PrintWriter out = resp.getWriter();

       try {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/demo",
            "user",
            "password"
        );
        out.println("<h2>Employee DB Connection Object</h2>");
        out.println("<p>" + conn + "</p>");

        servletContext.setAttribute("conn", conn);
       } catch (Exception e) {
            out.println("<h2>Exception in opening Connection</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            e.printStackTrace();
       }

        out.print("<h1> HELLO </h1>" );
        out.print("<h4> Servlet Params </h4>");
        out.print("<p>" + getServletParams() +  "</p>");
        out.print("</br>");
        out.print("<h4> Application Params </h4>");
        out.print("<p>" + getContextParams() +  "</p>");
        out.print("</br");

    }

    public String getServletParams() {
        List<String> params = Collections.list(servletConfig.getInitParameterNames());
        String value = params
            .stream()
            .sorted((a, b) -> (int)a.charAt(0) - (int)b.charAt(0))
            .map(i -> {
                String val = servletConfig.getInitParameter(i);
                return "Param: " + i + " Value: " + val;
            })
            .collect(Collectors.joining("<br/>"));

        System.out.println("string: " + value);
        return value;
    }

    public String getContextParams() {
        List<String> params = Collections.list(servletContext.getInitParameterNames());
        String value = params
            .stream()
            .sorted((a, b) -> (int)a.length() - (int)b.length())
            .map(i -> "Param: " + i + " Value: " + servletContext.getInitParameter(i))
            .collect(Collectors.joining("</br>"));
        return value;
    }
    
}