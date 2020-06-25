<html>
<body>
<%
pageContext.forward("date.jsp?Actress=kareena");

pageContext.forward("currentDateTime");

<!--following two forwards are not allowed -->

<!-- pageContext does not support static forwards -->

pageContext.forward("index.html");

pageContext.forward("myText.txt");


</body>
</html>