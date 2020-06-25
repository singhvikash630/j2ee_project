<%@ include file="jsp/header.jsp" %>
<%@page import="com.jspider.login.pojo.Students" %>
<%
Students studentinfo=(Students)session.getAttribute("studentinfo");
String msg=request.getParameter("msg");
%>
<html>
<body>
<%String encodeURL=response.encodeURL("changePassword"); %>
<form action=<%=encodeURL%> method="post"/>
<br>
<h1 align=center><font color="red"><%=msg %></font></h1>
<br>
Old Password: <input type="password" name="formpassword" value=<%=studentinfo.getUsers().getPassword()%> />
<br>
New Password : <input type="password" name="newpassword"/>
<br>
Confirm Password : <input type="password" name="confirmnewpassword"/>
<br>
<input type="submit" value="submit" />&nbsp
<input type="submit" value="reset" />

<%@ include file="jsp/footer.jsp" %>

</body>
</html>