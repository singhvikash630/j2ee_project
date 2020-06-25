<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title herse</title>
</head>
<body>
<%@include file="/test1.jsp" %>
<%
out.println(new Date());
System.out.println("i am in service method");
out.println("welcome to jsp");
page.

%>
</body>

</html>