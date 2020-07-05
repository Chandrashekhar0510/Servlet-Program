package com.ServletApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.*;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//String password = "sahul";
		String username = req.getParameter("Username");
		String pass = req.getParameter("pswd");
		
		String passRegex = "^([a-zA-Z0-9]*)[^a-zA-Z0-9\\s]([a-zA-Z0-9]*)$";
		String userRegex = "^([A-Z]{1}+[a-zA-Z]{2,})$";
				
		Pattern passPattern = Pattern.compile(passRegex);
		Matcher passMatch = passPattern.matcher(pass);

		Pattern userPattern = Pattern.compile(userRegex);
		Matcher userMatch = userPattern.matcher(username);
		
		boolean isValidPass = passMatch.matches();
		boolean isValidUser = userMatch.matches();
		
		PrintWriter out = resp.getWriter();
		
		if(isValidUser == true)
		{
			if(isValidPass == true)
			{
				String htmlresponse = "<html>";
				
				htmlresponse += "<h1>Login Successfull"+"</h1>";
				htmlresponse += "<h1>Username is : "+username+"</h1>";
				htmlresponse += "<h1>Password is : "+pass+"</h1>";
				htmlresponse += "</html>";
				
				out.println(htmlresponse);
			}
			else
			{
				String errorResponse = "<html>";
				
				errorResponse += "<h1>Username is : "+username+"</h1>";
				errorResponse += "<h1>Invalid Password"+"</h1>";
				errorResponse += "</html>";
			
				out.print(errorResponse);
			}
		}
		else
		{
			String errorResponse = "<html>";
			
			errorResponse += "<h1>Invalid Username"+"</h1>";
			errorResponse += "</html>";
			
			out.print(errorResponse);
		}
		//System.out.println("Username is : "+username);
		//System.out.println("Password is : "+pass);
	}
}