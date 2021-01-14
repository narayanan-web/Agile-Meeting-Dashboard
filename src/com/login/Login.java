package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;

import java.sql.*;
@WebServlet("/Login")
public class Login extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
			
		LoginDao dao = new LoginDao();
		String name = dao.check(email, pass);
		if(name!="#")
		{
			HttpSession session = request.getSession();
			session.setAttribute("email",email);
			session.setAttribute("name", name);
			response.sendRedirect("dashboard.jsp");
		}
		else
		{
			response.sendRedirect("login.html");
		}
	}
}
