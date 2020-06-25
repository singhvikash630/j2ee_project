package com.jspider.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrentDateTime extends HttpServlet
{
	int count=0;
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
			{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("current,Date & time:"+new Date());
		count++;
		out.println("count:"+count);
		
	}

}
