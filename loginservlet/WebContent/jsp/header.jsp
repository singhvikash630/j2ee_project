<html>
<body>
<% 
String encodeHome=response.encodeURL("ListStudents");
String encodeLogout=response.encodeURL("Logout");
String encodeChangePassword=response.encodeURL("changePassword");
String encodeAddUser=response.encodeURL("addUser");
%>

<b><a href="<%=encodeHome%>">Home</a></b>&nbsp;
<b><a href="<%=encodeAddUser%>">Create User</a></b>&nbsp;

<b><a href="<%=encodeChangePassword%>">ChangePassword</a></b>&nbsp;
<b><a href="<%=encodeLogout%>">Logout</a></b>&nbsp;

</body>
</html>