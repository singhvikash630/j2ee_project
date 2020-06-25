<html>
<body>

<%--Dynamic forward:SERVLET --%>
 <jsp:forward page="currentDateTime"/> 
 
<jsp:forward page="currentDateTime?Actress=kareena"/> 
 
<jsp:forward page="currentDateTime">
<jsp:param value="Amir Khan" name="Actor"/>
</jsp:forward>



<%--Dynamic forward:JSP --%>
<%--Configured URL in web.xml --%>
 <jsp:forward page="date?Actress=kareena"/>
 
<jsp:forward page="date">
<jsp:param value="kareena" name="Actress"/>
</jsp:forward>

 <jsp:forward page="implicitObjectJsp/date.jsp"/>


<%--static forward:HTML --%>
<%-- <jsp:forward page="index.html"/> --%>

 
<%--static forward:TEXT --%>
<%--<jsp:forward page="myText.txt"/> --%>



</body>
</html>