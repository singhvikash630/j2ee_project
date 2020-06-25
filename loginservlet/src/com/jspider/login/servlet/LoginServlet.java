package com.jspider.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspider.login.dao.LoginDAO;
import com.jspider.login.dao.impl.LoginDAOImpl;
import com.jspider.login.pojo.Students;

public class LoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
			{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String regNo=req.getParameter("regno");
		String password=req.getParameter("password");
		if(regNo==null || regNo.equalsIgnoreCase("") || password==null || password.equalsIgnoreCase(""))
		{
			//String errMsg="LoginError?loginError=Session Expire";
			String encodeErrorMsg=res.encodeRedirectURL("LoginError?loginError=Session Expire");
			res.sendRedirect(encodeErrorMsg);	
		}
		else
		{
		int regno=Integer.parseInt(req.getParameter("regno"));
		List<Students> dataList=null;
		Students studentinfo=null;
		LoginDAO dao=new LoginDAOImpl();
		
		try {
			studentinfo=dao.authenticateUsers(regno, password);
			if(studentinfo!=null)
			{
				HttpSession session=req.getSession();
				session.setMaxInactiveInterval(60);
				session.setAttribute("studentinfo",studentinfo);
				if(studentinfo.getUsers().getIsadmin().equalsIgnoreCase("y"))
				{
					List<Students> studentList=dao.getAllStudentInfo();
					 dataList=studentList;
					 session.setAttribute("isAdmin","y");
					 
				}
				else
				{
					dataList=new ArrayList<Students>();
					dataList.add(studentinfo);
					session.setAttribute("isAdmin","n");
				}
				session.setAttribute("studentList",dataList);
				String forwardURL=res.encodeURL("ListStudents");
				RequestDispatcher dispatcher=req.getRequestDispatcher(forwardURL);
				dispatcher.forward(req,res);
				
				
			}
			
			else
			{
				String errMsg="LoginError?loginError=please provide valid credentials";
				String encodeErrorMsg=res.encodeRedirectURL(errMsg);
				res.sendRedirect(encodeErrorMsg);
					
			}
		} 
	
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

			}	
	
	
	
			}

protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
	doPost(req,res);
	}
}