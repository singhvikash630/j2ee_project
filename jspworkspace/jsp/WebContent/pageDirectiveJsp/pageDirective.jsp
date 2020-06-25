<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 --%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page language="java" %>

<%@page info=”MyFirst.jsp” %>

<%@page contentType=”text/html” %>
<%@page contentType=”text/html;charset=ISO-8859-1” %>

<%@page import=”pkg1.class_name,pkg2.class_name” %>
<%@page import=”java.util.Date”%>

<%@page extends=“org.apache.jasper.runtime.HttpJspBase”  %>

<%@page buffer=”8kb” %>

<%@page autoFlush=”true | false” %>

<%@page session=”true | false” %>

<%@page isThreadSafe=”true | false” %>

<%@page isErrorPage=”true | false” %>

<%@page errorPage=”redirectedURL” %>

</body>
</html>