<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
    <title>First Java EE Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
        }
        .container {
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.2);
            text-align: center;
            max-width: 500px;
        }
        h1 {
            color: #667eea;
            margin-bottom: 20px;
        }
        .date-box {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
            margin: 20px 0;
            border: 2px solid #667eea;
        }
        .date-box strong {
            color: #764ba2;
            font-size: 1.2em;
        }
        a {
            display: inline-block;
            background: #667eea;
            color: white;
            padding: 12px 30px;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 15px;
            transition: background 0.3s;
        }
        a:hover {
            background: #764ba2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🚀 Hello from Java EE!</h1>
        <p>This is a <strong>dynamic</strong> web application</p>
        
        <div class="date-box">
            <h3>Current Date & Time:</h3>
            <% 
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm:ss");
                String formattedDate = now.format(formatter);
            %>
            <strong><%= formattedDate %></strong>
        </div>
        
        <a href="getDate">Get Date from Servlet</a>
        
        <p style="margin-top: 20px; color: #666;">
            <small>Refresh the page to see the time update! ⏰</small>
        </p>
    </div>
</body>
</html>