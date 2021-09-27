package com.signup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignupDao 
{
	String sql="insert into login values(?,?,?)";
	String url ="jdbc:mysql://localhost:3306/Agile_Meeting";
	String username="root";
	String password="";	//pet name
	public boolean check(String name, String email, String pass) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, pass);
			st.execute();
			System.out.print("Now it's Working");
			return true;
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		return false;
	}
}
