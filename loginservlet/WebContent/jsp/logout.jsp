<html>
<body>
	<%
		session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			response.sendRedirect("LoginError?loginError=logout Successful");
		} else {
			response.sendRedirect("LoginError?loginError=Session Expire");

		}
	%>

</body>
</html>

