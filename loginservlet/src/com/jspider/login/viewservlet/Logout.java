package com.jspider.login.viewservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet
{
protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
	HttpSession session=req.getSession(false);
	if(session!=null)
	{
		session.invalidate();
		res.sendRedirect("LoginError?loginError=logout Successful");
	}
	else
	{
		res.sendRedirect("LoginError?loginError=you have not logged in,please login");	
	}
	}
}
