package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Servlet implementation class ProductUpdateServlet
 */

@WebServlet("/PUpdateServlet")
public class PUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Statement st;
		Connection conn=null;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			  //out.println("hello");
	    	   Class.forName("oracle.jdbc.driver.OracleDriver");
			   conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vivek597","nakka597");
			   st=conn.createStatement();
			   if("logout".equals(request.getParameter("logout")))
					   {
				             response.sendRedirect("logout.jsp");
					   }
			   else if("view".equals(request.getParameter("view"))) {
				    response.sendRedirect("viewproducts.jsp");
			   }
			
		}catch(Exception e) {
	    	out.println(e.getMessage());
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
