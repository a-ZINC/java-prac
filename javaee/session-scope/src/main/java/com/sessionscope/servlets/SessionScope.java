package com.sessionscope.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionScope extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object isVisited = session.getAttribute("isVisited");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        out.println("<html><body>");
        if (isVisited == null) {
            // First visit - set attribute
            session.setAttribute("isVisited", true);
            out.println("<h2>Thanks for visiting our application!</h2>");
        } else {
            // Return visit - attribute exists
            out.println("<h2>Welcome back!</h2>");
        }

    }

    

}