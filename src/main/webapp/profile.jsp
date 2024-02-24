<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.sql.*,java.io.*,jakarta.servlet.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<style>
        table {
            border-collapse: collapse;
            width: 10%;
            justify-content:center;
            margin:auto;
        }
         td {
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
	    out.println("<h1>Profile</h1><br>");
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vivek597","nakka597");
	   st=conn.createStatement();
	   ResultSet rs=st.executeQuery("select * from userdetails where username='"+session.getAttribute("username")+"'");
      ResultSetMetaData rmd=rs.getMetaData();
      int columnCount = rmd.getColumnCount();
      while(rs.next()){
    	  out.println("<table >");
      for (int i = 1; i <= columnCount; i++) {
    	 if(i!=2)
         {
    		 
         out.println("<tr>");
    	 out.println("<td>"+rmd.getColumnName(i)+"</td>");
    	 out.println("<td>"+rs.getString(i)+"</td>");
    	 out.println("</tr>");
    	
         }
      }
      out.println("</table>");
      }
      conn.close();
}catch(Exception e){
	out.println(e.getMessage());
}
	   %>

</body>
</html>