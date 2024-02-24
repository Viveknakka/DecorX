package com.example;

import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class orderServlet
 */
public class orderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  PrintWriter out=response.getWriter();
           response.setContentType("text/html");
	    	String fname=request.getParameter("fName");
            String lname=request.getParameter("lName");
            String designNo=request.getParameter("designNo");
            String eventType=request.getParameter("eventSelect");
            
            out.println("fname:"+fname+"lname:"+lname+"deno:"+designNo+"eventype"+eventType);
           try {
        	   Class.forName("oracle.jdbc.driver.OracleDriver");
        	   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
        	   PreparedStatement ps=conn.prepareStatement("insert into orderDetails values(?,?,?,?,?)");
        	   ps.setString(1, fname);
        	   ps.setString(2, lname);
        	   ps.setInt(3,Integer.valueOf(designNo));
        	   ps.setString(4, eventType);
        	   ps.setInt(5,15999);
        	   boolean flag=ps.execute();
        	   if(!flag)
        	   {
        		   out.println("<h1>"+fname+" your order is confirmed....</h1>");
        	   }
        	   else
        	   {
        		   out.println("<h1>"+fname+" sorry your order is not confirmed....</h1>");
        	   }
        	   conn.close();
           }
           catch(Exception e) {
        	   e.printStackTrace();
        	  // System.out.println(e.getMessage());
           }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
