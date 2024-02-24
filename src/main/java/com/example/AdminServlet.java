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
import java.sql.Statement;

/**
 * Servlet implementation class AdminServlet
 * 
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());

		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Statement st;
		Connection conn=null;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {out.println("hello");
	    	   Class.forName("oracle.jdbc.driver.OracleDriver");
			   conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vivek597","nakka597");
			   st=conn.createStatement();
			   ResultSet rs=st.executeQuery("select username,password from admindetails");
	           String uname=request.getParameter("uname");
	           String pass=request.getParameter("password");
			   while(rs.next())
	           {
	        	   if(rs.getString(1).equals(uname) && rs.getString(2).equals(pass)) {
	        		     out.println("Login success...");
	        		     HttpSession session = request.getSession();
		        		   session.setAttribute("username", uname);

	        		   response.sendRedirect("adminhome.jsp");
	        	
	        	   }
	           }
			   out.println("incorrect username or password...");
		}catch(Exception e) {
	    	out.println(e.getMessage());
	    }finally {
	    	if(conn!=null)
	    	{
	    		try{
	    			conn.close();
	    		}catch(Exception e) {
	    			out.println("<h1>errot</h1>");
	    		}
	    	}
	    		
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
