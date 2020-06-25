<%@page import="com.jspider.login.pojo.Students"%>
<%@page import="java.util.List"%>
<%session=request.getSession(false);%>
<%if(session==null)
{%>
    <% String encodeURL=response.encodeRedirectURL("LoginError?loginError=Session Expire"); %>
	<% response.sendRedirect(encodeURL);%>
<% }
else
{%>
<html>
<body>
<% 
List<Students> studentList=(List<Students>)session.getAttribute("studentList");
String userType=(String)session.getAttribute("isAdmin");
%>
<%@include file="/jsp/header.jsp" %>
<h1 align=center>Valid User</h1>
<%if(studentList!=null)
    { %>
    <br>
    <h3 align=center>show student record</h3>
    <br>
    <br>
		<html>
		<body bgcolor=pink>
		<table width=100% border=1>
		<tr bgcolor=pink>
		       <td><b>Regno</b></td>
		       <td><b>Fname</b></td>
		       <td><b>Mname</b></td>
		       <td><b>Lname</b></td>
		       <td><b>Edit</b></td>
		       <td><b>Delete</b></td>
       <%for(Students datalist:studentList)
		{%>
		<tr>
					<td><%=datalist.getRegno() %></td>
					<td><%=datalist.getFname()%></td>
					<td><%=datalist.getMname()%></td>
					<td><%=datalist.getLname()%></td>
					
			<%if(userType.equalsIgnoreCase("y"))
					{
					String editEncodeURL=response.encodeURL("./modifyUser?regno="+datalist.getRegno()+"&action=edit");
					String deleteEncodeURL=response.encodeURL("./modifyUser?regno="+datalist.getRegno()+"&action=delete");
		     %>
					<td><a href=<%=editEncodeURL %>>edit</a></td>
					<td><a href=<%=deleteEncodeURL %>>delete</a></td>
			<%}else
			         {%>
			          <td><a href="#">N/A</a></td>
			          <td><a href="#">N/A</a></td>
				   <%} %>
		</tr>
		<%} %>
		</table>
</body>
</html>
<%@include file="/jsp/footer.jsp" %>


<%}}%>