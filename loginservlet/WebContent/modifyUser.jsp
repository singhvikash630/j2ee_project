<%@ include file="jsp/header.jsp" %>
<%@page import="com.jspider.login.pojo.Students" %>
<%
Students studentinfo=(Students)session.getAttribute("studentlist");
%>
<html>
<body>
<%String encodeURL=response.encodeURL("modifyUser"); %>
<form action=<%=encodeURL%> method="post"/>
<br>
<%="edit the data" %>
<br>
First Name : <input type="text" name="fname" value=<%=studentinfo.getFname()%> />
<br>
Middle Name : <input type="text" name="mname" value=<%=studentinfo.getMname()%> />
<br>
Last Name : <input type="text" name="lname" value=<%=studentinfo.getLname()%> />
<br>

<input type="submit" value="submit" />&nbsp
<input type="submit" value="reset" />

<%@ include file="jsp/footer.jsp" %>


</body>
</html>