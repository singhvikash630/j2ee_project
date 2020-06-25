<html>
<body>
<jsp:useBean id="myBean" class="com.servlet.bean.JspBean" scope="session"/>
Age:<jsp:getProperty property="age" name="myBean"/>
<br>
Name:<jsp:getProperty property="name" name="myBean"/>
<br>

<jsp:include page="CurrentDateTime"/>
<br>
<jsp:setProperty property="age" name="myBean" value="90"/>
<jsp:setProperty property="name" name="myBean" value="vikash"/>
<br>
Age:<jsp:getProperty property="age" name="myBean"/>
<br>
Name:<jsp:getProperty property="name" name="myBean"/>
</body>
</html>