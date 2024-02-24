<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 body{
   background-color:#598076;
 }
</style>
</head>
<body>
<%if(session!=null){session.invalidate(); %>
<h1>you are successfully logged out....</h1>
<%
  response.sendRedirect("index.jsp");
} else{ %>
<h1>your not yet logined...</h1>
<%} %>
</body>
</html>