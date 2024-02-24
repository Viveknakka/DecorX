<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.io.*,jakarta.servlet.*,java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your cart</title>
<style>
        table {
            border-collapse: collapse;
            width: 10%;
            justify-content:center;
            margin:auto;
        }
         th,td {
         color:aqua;
         background-color:#598076;
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px; /* Adjust the padding as needed */
        }
        h1{
           color:yellow;
           text-align:center;
        }
    body{
       background-color: #596476;
       }
    </style>
</head>
<body>
<%!
   Connection conn;
   Statement st;
   
%>
<%try{
	 if(session.getAttribute("username")==null)
	      response.sendRedirect("userlogin.html");
	    out.println("<h1>YOUR CART</h1><br>");
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vivek597","nakka597");
	   st=conn.createStatement();
	   ResultSet rs=st.executeQuery("select username from cart where username='"+session.getAttribute("username")+"'");
       int i=0;
       int cnt=rs.getMetaData().getColumnCount();
      while(i-->0){
    	  out.println("<tr>");
    	  rs.next();
        ResultSet rs1=st.executeQuery("select p.pname,p.price,p.imagepath,p.rating from products p,cart c where p.pid='" +rs.getString(1)+"'");
       rs1.next();
        out.println("<td>");
        out.println("<h1>"+rs1.getString(1)+"</h1>");
        out.println("<img src='"+rs1.getString(3)+"'>");
        out.println("<br>Rating:"+rs1.getString(4)+"/5");
        out.println("<br>Price:"+rs1.getString(2));
        out.println("</td>");
        out.println("</tr>");
      }
      out.println("</table>");
      
      conn.close();
}catch(Exception e){
	out.println(e.getMessage());
}
	   %>
</body>
</html>