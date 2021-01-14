package com.signup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;
import com.signup.dao.SignupDao;


@WebServlet("/Signup")
public class Signup extends HttpServlet 
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		SignupDao dao = new SignupDao();
		if(dao.check(name,email, pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("email",email);
			response.sendRedirect("login.html");
		}
		else
		{
			response.sendRedirect("signup.html");
		}
		
		
		
	}

}
