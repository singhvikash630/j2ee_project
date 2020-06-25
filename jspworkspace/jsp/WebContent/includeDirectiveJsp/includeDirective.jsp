<html>
<head>
</head>
<body>
My Jsp
<%@include file="/implicitObjectJsp/date.jsp" %>
<%@ include file="index.html" %>
<%@ include file="myText.txt" %>

<!-- we can use jsp along with query parameter in include directive -->
<%-- <%@include file="/implicitObjectJsp/date.jsp?Actress=kajol" %>
 --%>
 <!-- we can use servlets in include dorective -->
 <%-- <%@include file="currentDateTime" %> --%>

</body>
</html>