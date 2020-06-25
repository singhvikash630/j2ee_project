<html>
<head>
</head>
<body>
<% session=request.getSession(false);%>
<% if(session==null)
	{%>
	
    <h1 align=center><font color="red"><%=request.getParameter("loginError")%></font></h1>
    <%@include file="/jsp/login.jsp" %>
  <%} 
else
	{%>
	<h1 align=center><font color="red"><%=request.getParameter("loginError")%></font></h1>
    <%@include file="/jsp/login.jsp" %>
	<%} %>
	
</body>
</html>


