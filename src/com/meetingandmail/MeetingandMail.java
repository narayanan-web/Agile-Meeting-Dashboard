package com.meetingandmail;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*;


@WebServlet("/MeetingandMail")
public class MeetingandMail extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	/*StringBuilder req = new StringBuilder();
		BufferedReader reader = request.getReader();
		//PrintWriter out = response.getWriter();
		req.append(reader.readLine());
		System.out.println(req);*/
    	HttpSession session2 = request.getSession();
   	 	String host = session2.getAttribute("name").toString();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String link = request.getParameter("link");
		String date = request.getParameter("date");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String temp = host+","+request.getParameter("peoples");
		String[] peoples = temp.split("[,]", 0);
		peoples = Arrays.stream(peoples).distinct().toArray(String[]::new);
		int size = peoples.length;
	    String[] recipients = new String[size];
	    int j=0;
		
		StringBuilder sb = new StringBuilder();
		for (String str : peoples)
			sb.append(str).append(",");
		String datapeoples = sb.substring(0, sb.length() - 1);
		
		String sql="insert into meeting values(?,?,?,?,?,?,?)";
		String sql2="select distinct (email) from login where name=?;";
		String url ="jdbc:mysql://localhost:3306/Agile_Meeting";
		String username="root";
		String password="Jaggufriend";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, description);
			st.setString(3, link);
			st.setString(4, date);
			st.setString(5, starttime);
			st.setString(6, endtime);
			st.setString(7, datapeoples);
			st.execute();
			System.out.println("Meeting created Success");
			
			//----------------Mail--------------------//
			//email ID of Recipient. 
			for(String i: peoples)
		    {
		      PreparedStatement st2=con.prepareStatement(sql2);
		      st2.setString(1, i);
		      ResultSet rs = st2.executeQuery();
		      rs.next();
		      recipients[j]=rs.getString(1);
		      j++;
		    }
			StringBuilder sb2 = new StringBuilder();
			for (String str : recipients)
				sb2.append(str).append(",");
			String recipientsarray = sb2.substring(0, sb2.length() - 1);
		  
		      // email ID of Sender. 
		      String sender = "vsoft.meetings@outlook.com"; 
		  
		      // Getting system properties 
		      Properties properties = System.getProperties(); 
		  
		      properties.put("mail.smtp.auth","true");
		      properties.put("mail.smtp.starttls.enable","true");
		      properties.put("mail.smtp.host","smtp.office365.com");
		      properties.put("mail.smtp.port","587");
		       
		      // creating session object to get properties 
		      Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator()
		      {
		    	  protected PasswordAuthentication getPasswordAuthentication()
		    	  {
		    		  return new PasswordAuthentication("vsoft.meetings@outlook.com","VirtusaProject");
		    	  }
		      });
		  
		      try 
		      {
		         // MimeMessage object. 
		         MimeMessage message = new MimeMessage(session); 
		  
		         // Set From Field: adding senders email to from field. 
		         message.setFrom(new InternetAddress(sender,"Vsoft Meeting Dashboard")); 
		  
		         // Set To Field: adding recipient's email to from field. 
		         message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientsarray)); 
		  
		         // Set Subject: subject of the email 
		         message.setSubject(title+" - Reminder"); 
		  
		         // set body of the email. 
		         BodyPart messageBody1 = new MimeBodyPart();
		         messageBody1.setContent("<p>Hi,</p><p><b>"+host+"</b>"+" is inviting to a meeting, Kindly join on-time</p>","text/html");
		         
		         BodyPart messageBody2 = new MimeBodyPart();
		         //messageBody2.setContent("<h1>This is a HTML text</h1><br>","text/html");
		         messageBody2.setContent("<p><b>Topic</b> : "+title+"</p><p><b>Description</b> : "+description+"</p><p><b>Date</b> : "+date+"</p><p><b>Time</b> : "+starttime+" - "+endtime+"</p>","text/html");
		         
		         BodyPart messageBody3 = new MimeBodyPart();
		         messageBody3.setContent("<p>-----------------------------</p><p><b><a href="+link+">Meeting Link is here</a></b></p><p>-----------------------------</p><br><p>Regards</p><p>Vsoft-Team</p>","text/html");
		        
		         BodyPart messageBody4 = new MimeBodyPart(); 
		         messageBody4.setContent("<img src=\"https://fehr2w.dm.files.1drv.com/y4mFvO7wg6Yr1xyweVRvcUwyKGOPslC1A2l1IKMbKHMUxFe7NijQ7zFOuOS06LE6zI69g0IFvd3JBYr1cHncCZmU0_xiZMiswjgcp1D2Yurxn9K4idRLBHAClVTKSREZe9m38bhKc8m-ZnoMf1rr6KyiJDrRTbJXbJwrdp54MZcRz9fNGFYStQx6k4RYhTQgy7ry2WUd3ADZHm8OMz8TTEXJQ?width=256&height=174&cropmode=none\" width=\"128\" height=\"87\" />","text/html");
		         
		         Multipart multipartObject = new MimeMultipart();   
		         multipartObject.addBodyPart(messageBody1);   
		         multipartObject.addBodyPart(messageBody2);
		         multipartObject.addBodyPart(messageBody3); 
		         multipartObject.addBodyPart(messageBody4); 
		         
		         message.setContent(multipartObject);
		         
		         // Send email. 
		         Transport.send(message); 
		         System.out.println("Mail successfully sent"); 
		      } 
		      catch (MessagingException e)  
		      { 
		         e.printStackTrace(); 
		      }  
		     //--------------------------//
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
    }
}
