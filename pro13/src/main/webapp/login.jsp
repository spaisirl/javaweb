<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
 <h1>login.jsp - top</h1>
 <jsp:forward page="result.jsp">
 	<jsp:param value="hong" name="name"/>
 	<jsp:param value="cat.png" name="imgName"/>
 </jsp:forward>
 <h1>login.jsp - bottom</h1>
</body>
</html>