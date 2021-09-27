package com.update;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Updatepass")
public class Updatepass extends HttpServlet 
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String sql="update login set pass=? where email=?";
		String url ="jdbc:mysql://localhost:3306/Agile_Meeting";
		String username="root";
		String password="";	//pet name
		PrintWriter out = response.getWriter();
		String pass = request.getParameter("pass");
		try 
		{
			
			
			HttpSession session = request.getSession();
			String str = session.getAttribute("email").toString();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pass);
			st.setString(2, str);
			int f=0;
			int r=st.executeUpdate();
			if(r>0)
			{
				System.out.println("User Password is updated");
				//response.sendRedirect("dashboard.jsp");
				f++;
				out.println(f);
			}
			else
			{
				System.out.println("Not Updated password");
				response.sendRedirect("profile.jsp");
			}

		
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}

}
