package com.jspider.login.viewservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginError extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
			{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			out.println("<h1 align=center>"+"<font color=\"red\">"+req.getParameter("loginError")+"</font>"+"</h1>");
			//String editURL=res.encodeURL("jsp/login.jsp");
			RequestDispatcher dispatcher2=req.getRequestDispatcher("jsp/login.jsp");
			dispatcher2.include(req,res);
		}
		else
		{
			out.println("<h1 align=center>"+"<font color=\"red\">"+req.getParameter("loginError")+"</font>"+"</h1>");
			//String editURL=res.encodeURL("jsp/login.jsp");
			RequestDispatcher dispatcher=req.getRequestDispatcher("jsp/login.jsp");
			dispatcher.include(req,res);

		}
}
}
