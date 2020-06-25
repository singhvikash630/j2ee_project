package com.jspider.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.jspider.login.dao.LoginDAO;
import com.jspider.login.dao.impl.LoginDAOImpl;
import com.jspider.login.pojo.Students;

public class ChangePassword extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
			{

		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		RequestDispatcher dispatcher=req.getRequestDispatcher("jsp/header.jsp");
		RequestDispatcher dispatcher1=req.getRequestDispatcher("jsp/footer.jsp");
		dispatcher.include(req,res);
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			out.println("<br>");
			String encodeURL=res.encodeRedirectURL("LoginError?loginError=Session Expire");
			res.sendRedirect(encodeURL);
		
		}
		else
		{
			out.println("<br>");
			Students studentinfo=(Students)session.getAttribute("studentinfo");
			int regno=studentinfo.getRegno();
			String password=studentinfo.getUsers().getPassword();
			String formpassword=req.getParameter("formpassword");
			if(password.equals(formpassword))
			{

				String newpassword=req.getParameter("newpassword");
				String confirmnewpassword=req.getParameter("confirmnewpassword");
				if(newpassword==null || confirmnewpassword==null || newpassword.equalsIgnoreCase("") || confirmnewpassword.equalsIgnoreCase(""))
				{
					String encodeURL=res.encodeRedirectURL("changePassword.jsp?msg=please provide the valid password");
					res.sendRedirect(encodeURL);
				
				}
				else
				{				
					if(newpassword.equals(confirmnewpassword))
					{ 	 
						LoginDAO dao=new LoginDAOImpl();
						try {
							dao.updateUserPassword(regno,newpassword);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						out.println("password change successfully");
					}
					else
					{
						String encodeURL=res.encodeRedirectURL("changePassword.jsp?msg=please provide the valid password");
						res.sendRedirect(encodeURL);
					}
				}


			}
			else{
				String encodeURL=res.encodeRedirectURL("changePassword.jsp?msg=please provide the valid password");
				res.sendRedirect(encodeURL);
			}

			dispatcher1.include(req,res);
			

		}
			}
	
	@Override
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
			out.println("<br>");
			String encodeURL=res.encodeRedirectURL("changePassword.jsp?msg=enter the new password");
			res.sendRedirect(encodeURL);
		    //doPost(req, res);
			}
}
}

