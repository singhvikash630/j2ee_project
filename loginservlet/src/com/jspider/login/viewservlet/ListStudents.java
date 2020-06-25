package com.jspider.login.viewservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspider.login.pojo.Students;

public class ListStudents extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
			{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		RequestDispatcher dispatcher=req.getRequestDispatcher("jsp/header.jsp");
		RequestDispatcher dispatcher1=req.getRequestDispatcher("jsp/footer.jsp");
		HttpSession session=req.getSession(false);
		List<Students> studentList=(List<Students>)session.getAttribute("studentList");
		String userType=(String)session.getAttribute("isAdmin");
		if(session==null)
		{
			res.sendRedirect("LoginError?loginError=Session Expire");
		}
		else
		{
			dispatcher.include(req,res);
			out.println("<h1 align=center>"+"Valid User"+"</h1>");
			if(studentList!=null)
			{
				out.println("<br>");
				String title="show student record ";
				out.println("<h3 align=center>"+title+"</h3>");
				constructHTMLPage2(out,studentList,userType,res);
				out.println("<br>");
				out.println("<br>");
				dispatcher1.include(req,res);
			}
			
		}
		out.close();
		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
			{
		doPost(req,res);
		}
	private void constructHTMLPage2(PrintWriter out,List<Students> dataList,String userType,HttpServletResponse res )
	{
		out.println("<br>");
		out.println("<br>");
		out.println("<html>");
		out.println("<body bgcolor=\"pink\">");
		out.println("<table width=\"100%\" border=1>");
		out.println("<tr bgcolor=\"pink\">");
		out.println("<td><b>Regno</b></td>");
		out.println("<td><b>Fname</b></td>");
		out.println("<td><b>Mname</b></td>");
		out.println("<td><b>Lname</b></td>");
		out.println("<td><b>Edit</b></td>");
		out.println("<td><b>Delete</b></td>");
		
		for(Students datalist:dataList)
		{
		out.println("<tr>"+
					"<td>"+datalist.getRegno()+"</td>"+
					"<td>"+datalist.getFname()+"</td>"+
					"<td>"+datalist.getMname()+"</td>"+
					"<td>"+datalist.getLname()+"</td>");
				    
					if(userType.equalsIgnoreCase("y"))
					{
					String editEncodeURL=res.encodeURL("./modifyUser?regno="+datalist.getRegno()+"&action=edit");
					String deleteEncodeURL=res.encodeURL("./modifyUser?regno="+datalist.getRegno()+"&action=delete");
					out.println("<td>"+"<a href="+editEncodeURL+">edit</a>"+"</td>");
					out.println("<td>"+"<a href="+deleteEncodeURL+">delete</a>"+"</td>");
					
					//out.println("<td>"+"<a href=\"./ModifyUser?regno="+datalist.getRegno()+"&action=edit\">edit</a>"+"</td>");
					//out.println("<td>"+"<a href=\"./ModifyUser?regno="+datalist.getRegno()+"&action=delete\">delete</a>"+"</td>");
					}
				   else
			          {
					  out.println("<td>"+"<a href=\"#\">N/A</a>"+"</td>");
					  out.println("<td>"+"<a href=\"#\">N/A</a>"+"</td>");
				      }
				out.println("</tr>\n");
		}
		out.println("</table");
		out.println("</body");
		out.println("</html");
		
		

	}


}
