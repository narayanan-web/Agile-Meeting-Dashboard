package com.update;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Update")
public class Update extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sql="update login set name=?, email=? where email=?";
		String url ="jdbc:mysql://localhost:3306/Agile_Meeting";
		String username="root";
		String password="";	//pet name
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		try 
		{
			
			
			HttpSession session = request.getSession();
			String str = session.getAttribute("email").toString();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, str);
			int r=st.executeUpdate();
			if(r>0)
			{
				System.out.println("User details are updated");
				//response.sendRedirect("dashboard.jsp");
			}
			else
			{
				System.out.println("Not Updated");
				response.sendRedirect("profile.jsp");
			}	
		
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}

}
