<%@ include file="/jsp/header.jsp" %>
<%String msg=request.getParameter("msg"); %>
<html>
<body>
<%String encodeURL=response.encodeURL("addUser"); %>
<form action=<%=encodeURL%> method="post" />
<h1 align=center><font color="red"><%=msg %></font></h1>
Reg No:<input type="text" name="regno" />
<br>
First Name:<input type="text" name="fname" />
<br>
Middle Name:<input type="text" name="mname" />
<br>
Last Name:<input type="text" name="lname" />
<br>
<input type="submit" value="submit" />

<%@ include file="/jsp/footer.jsp" %>

</body>
</html>