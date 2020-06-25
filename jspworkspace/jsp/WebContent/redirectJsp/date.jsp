<%@page import="java.util.Date" %>
<%!
int i=100;
public void jspInit()
{
	System.out.println("i am inside init() method");
}
public void jspDestroy()
{
System.out.println("i am inside destroy() method");
}
%>
<html>
<body>

<%--Implicit Object:config --%>
Actor:<%=config.getInitParameter("Actor") %>
<br>
<%--Implicit Object:request --%>
Actress:<%=request.getParameter("Actress") %>
<br>
<%--Implicit Object:application --%>
Email:<%=application.getInitParameter("email") %>
<br>
<%--Implicit Object:page --%>
Servlet Info:<%=((Servlet)page).getServletInfo() %>
<br>
<%--Implicit Object:response,out --%>
<br>
<%
Cookie myCookie=new Cookie("fname","vikash");
response.addCookie(myCookie);
out.println("first cookie created");
%>
<%--Implicit Object:pageContext --%>
<br>
<%
Cookie anotherCookie=new Cookie("lname","singh");
HttpServletResponse res=(HttpServletResponse)pageContext.getResponse();
JspWriter outstream=pageContext.getOut();
res.addCookie(anotherCookie);
outstream.println("second cookie created");
%> 
 
</body>
</html>