package com.example;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   String uname=request.getParameter("uname");
	   String password=request.getParameter("password");
	   String firstname=request.getParameter("firstname");
	   String lastname=request.getParameter("lastname");
	   String email=request.getParameter("email");
	   String village=request.getParameter("village");
	   String mandal=request.getParameter("mandal");
	   String district=request.getParameter("district");
	   String address=request.getParameter("address");
	   String mobileno=request.getParameter("mobileno");
	   String pinno=request.getParameter("pinno");
	   String gender=request.getParameter("gender");
	   String state=request.getParameter("state");
	   Connection conn = null;
	   try {
		   
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vivek597","nakka597");
		   Statement st=conn.createStatement();
		   PreparedStatement ps=conn.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		   ps.setString(1,uname);
		   ps.setString(2,password);
		   ps.setString(3,firstname);
		   ps.setString(4,lastname);
		   ps.setString(5,gender);
		   ps.setString(6,mobileno);
		   ps.setString(7,email);
		   ps.setString(8,address);
		   ps.setString(9,village);
		   ps.setString(10,mandal);
		   ps.setString(11,district);
		   ps.setString(12,pinno);
		   ps.setString(13,state);
		   
		   boolean flag=ps.execute();
    	   if(!flag)
    	   {
    		   out.println("<h1>"+firstname+" you registered successfully....</h1>");
    	   }
    	   else
    	   {
    		   out.println("<h1>"+firstname+" I think you entered wrong details</h1>");
    	   }
    	  
		   out.println("<h1>you Registered sucessfully</h1>");
	   }
	   catch(Exception e)
	   {
		   out.println("<h1> you are already registered .. </h1>");
		   //e.printStackTrace();
	   }
	   finally
	   {
		   if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
