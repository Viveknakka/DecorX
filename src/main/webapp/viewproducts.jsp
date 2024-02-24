<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.io.*,jakarta.servlet.*,java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
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
	      response.sendRedirect("adminlogin.html");
	    out.println("<h1>Products</h1><br>");
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vivek597","nakka597");
	   st=conn.createStatement();
	   ResultSet rs=st.executeQuery("select * from products");
      ResultSetMetaData rmd=rs.getMetaData();
      int columnCount = rmd.getColumnCount();
      out.println("<table >");
      out.println("<tr>");
      for (int i = 1; i <= columnCount; i++)
      {
    	  out.println("<th>"+rmd.getColumnName(i)+"</th>");
      }
     
      out.println("</tr>");
      while(rs.next()){
    	  out.println("<tr>");
      for (int i = 1; i <= columnCount; i++) {
        
    	  if(i!=5)
    	 out.println("<td>"+rs.getString(i)+"</td>");
    	  else{
    		  out.println("<td><img src='"+rs.getString(i)+"'></td>");
    	  }
    	
         }
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