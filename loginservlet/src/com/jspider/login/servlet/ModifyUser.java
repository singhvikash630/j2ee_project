package com.jspider.login.servlet;

import java.awt.Desktop.Action;
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

public class ModifyUser extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
			{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession(false);
		RequestDispatcher dispatcher=req.getRequestDispatcher("jsp/header.jsp");
		RequestDispatcher dispatcher1=req.getRequestDispatcher("jsp/footer.jsp");
		if(session==null)
		{
			out.println("<br>");
			String encodeErrorMsg=res.encodeRedirectURL("LoginError?loginError=Session Expire");
			res.sendRedirect(encodeErrorMsg);	
		}
		else
		{
		dispatcher.include(req,res);
		out.println("<br>");
		int regno=Integer.parseInt(req.getParameter("regno"));
		String actionType=req.getParameter("action");
		out.println("<br>");		
		if(actionType.equalsIgnoreCase("edit"))
		   {
			List<Students> datatList=(List<Students>)session.getAttribute("studentList");
			for(Students studentlist:datatList )
			{
				if(regno==studentlist.getRegno())
				{
					session.setAttribute("studentlist", studentlist);
					String editURL=res.encodeRedirectURL("modifyUser.jsp");
					res.sendRedirect(editURL);
					
				}
				
			}
					
		   }
		else if(actionType.equalsIgnoreCase("delete"))
		{
			LoginDAO dao=new LoginDAOImpl();
			try {
				List<Students> dataList=null; 
				dao.deleteStudentInfo(regno);
				session.removeAttribute("studentList");
				List<Students> studentList=dao.getAllStudentInfo();
				dataList=studentList;
				session.setAttribute("studentList",dataList);
				out.println("delete successfully");

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		   {
			out.println("no action on students records");
			}
		}
		dispatcher1.include(req,res);
		

}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
			{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			out.println("<br>");
			res.sendRedirect("LoginError?loginError=Session Expire");
		}
		else
		{
		RequestDispatcher dispatcher=req.getRequestDispatcher("jsp/header.jsp");
		RequestDispatcher dispatcher1=req.getRequestDispatcher("jsp/footer.jsp");
		
		LoginDAO dao=new LoginDAOImpl();
		String fname=req.getParameter("fname");
		String mname=req.getParameter("mname");
		String lname=req.getParameter("lname");
		dispatcher.include(req,res);
		
		try {
			List<Students> dataList=null;
			Students studentinfo=(Students)session.getAttribute("studentlist");
			int oldRegno=studentinfo.getRegno();
			dao.updateStudentInfo(fname,mname,lname,oldRegno);
			session.removeAttribute("studentList");
			List<Students> studentList=dao.getAllStudentInfo();
			 dataList=studentList;
			 session.setAttribute("studentList",dataList);
			out.println("<br>");
			out.println("edit successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher1.include(req,res);
		
		
		}
	}
}
