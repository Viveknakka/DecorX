<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="java.sql.*,java.io.*,jakarta.servlet.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add to Cart</title>
</head>
<body>
 <%!
   Connection conn;
   Statement st;
   
%>
<%try{
	 if(session.getAttribute("username")==null)
	      response.sendRedirect("userlogin.html");
	    
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vivek597","nakka597");
	   st=conn.createStatement();
	   PreparedStatement ps=conn.prepareStatement("insert into cart values('?,?')");
	   Integer pid=Integer.parseInt((String)request.getAttribute("pid"));
	   String username=(String)session.getAttribute("username");
	   System.out.println("Usernanem"+username+"pid"+pid);
	   ps.setInt(1,121);
	   ps.setString(2,"vivek@123");
	   int r=ps.executeUpdate();
	   if(r>0){
		   out.println("<h1>design addedd to cart</h1>");
	   }
	   conn.close();
}catch(Exception e){
	out.println(e.getMessage());
}
	   %>
</body>
</html>