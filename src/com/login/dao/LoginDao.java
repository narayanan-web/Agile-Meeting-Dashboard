package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao 
{
	String sql="select * from login where email=? and pass=?";
	String url ="jdbc:mysql://localhost:3306/Agile_Meeting";
	String username="root";
	String password="Jaggufriend";
	public String check(String email,String pass)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, pass);
			ResultSet rs= st.executeQuery();
			if(rs.next())
			{
				System.out.print("Working");
				return rs.getString(1);
			}
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		System.out.print("Not Working");
		return "#";
	}
}