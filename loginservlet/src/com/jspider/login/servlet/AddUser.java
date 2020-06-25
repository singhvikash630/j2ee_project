package com.jspider.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

public class AddUser extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
			{
		       res.setContentType("text/html");
		       PrintWriter out=res.getWriter();
		       HttpSession session=req.getSession(false);
		       if(session==null)
		        {
			    out.println("<br>");
			    String encodeURL=res.encodeRedirectURL("LoginError?loginError=Session Expire");
			    res.sendRedirect(encodeURL);
                 }
		       else
		       {
			   String encodeURL=res.encodeRedirectURL("addUser.jsp?msg=Enter the User Details");
			   res.sendRedirect(encodeURL);
               }
		    }
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
			{
		   res.setContentType("text/html");
	       PrintWriter out=res.getWriter();
	       HttpSession session=req.getSession(false);
	       RequestDispatcher dispatcher=req.getRequestDispatcher("jsp/header.jsp");
			RequestDispatcher dispatcher1=req.getRequestDispatcher("jsp/footer.jsp");
			dispatcher.include(req,res);
			if(session==null)
	        {
		    out.println("<br>");
		    String encodeURL=res.encodeRedirectURL("LoginError?loginError=Session Expire");
		    res.sendRedirect(encodeURL);
          }
	       else
	       {
	    	 int regno=Integer.parseInt(req.getParameter("regno"));
	    	 String fname=req.getParameter("fname");
	    	 String mname=req.getParameter("mname");
	    	 String lname=req.getParameter("lname");
	    	 LoginDAO dao=new LoginDAOImpl();
	    	 try {
				dao.addUser(regno, fname, mname, lname);
				out.println("<br>");
			    out.println("Account Createed Successfully ");
			    session.removeAttribute("studentList");
			    List<Students> dataList=dao.getAllStudentInfo();
			    session.setAttribute("studentList", dataList);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
			dispatcher1.include(req,res);
			
	    }
		
		
		}

