<html>
<body>
<jsp:useBean id="myBean" class="com.servlet.bean.JspBean" scope="session"/>

Age:<jsp:getProperty property="age" name="myBean"/>
<br>
Name:<jsp:getProperty property="name" name="myBean"/>
<br>
</body>
</html>