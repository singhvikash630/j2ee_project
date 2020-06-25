<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<script type="javascript">
function validate()
{
var regno=document.frm.regno;
var pwd=document.frm.password;
var ischar=!@#$%^&*()+-{}[]":;?<>,';
if((regno.value==null)||(regno.value==" "))
{
alert("please eneter regno");
login.focus();
return false;
}
for(int i=0;i<document.frm.regno.value.length;i++)
{
if(ichar.indexof(document.frm.regno.value.charAt(i))!=-1)
{
alert(alert("please eneter regno");
return false;
}
}
for(int i=0;i<document.frm.password.value.length;i++)
{
if(ichar.indexof(document.frm.password.value.charAt(i))!=-1)
{
alert(alert("please eneter password");
return false;
}
}
if((pwd.value==null)||(pwd.value==" "))
{
alert("please eneter password");
pwd.focus();
return false;
}
return true;
}
</script>
</head>
<body bgcolor="pink">
	<form name="frm" action="LoginServlet" method="post"
		onsubmit="return valdidate()">
		<h2 align=center>Login Page</h2>
		<h3 align=center>
			Reg No:<input type="text" name="regno" />
		</h3>
		<h3 align=center>
			Password:<input type="password" name="password" />
		</h3>
		<h2 align=center>
			<input type="submit" value="Login">
		</h2>
	</form>

</body>
</html>