package cm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoTest extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
			{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("first_name");
		String password=req.getParameter("last_name");
		out.print("first_name:"+name);
		out.print("last_name:"+password);
		
	}

}
