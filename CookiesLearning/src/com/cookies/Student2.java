package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.Cookie;

public class Student2 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//getting all the cookies
		
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		boolean f = false;
		String name="";
		if(cookies==null) {
			out.println("<h1>You are new user go to homepage and submit your name </h1> ");
			return;
		}
		else {
			for(javax.servlet.http.Cookie c : cookies) {
				String tname=c.getName();
				if(tname.equals("user_name"))
				{
					f=true;
					name=c.getValue();
					
				}
			}
		}
		if(f) {
			out.println("<h1>Hello, " +name+" Welcome back to my website..</h1>");
		}
		else {
			out.println("<h1>You are new user go to homepage and submit your name </h1> ");
		}
		
}
}