<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include1.jsp</title>
</head>
<body>
	<h1>include1 - top</h1>
	<jsp:include page="image.jsp">
		<jsp:param value="hong" name="name"/>
		<jsp:param value="cat.png" name="imgName"/>
	</jsp:include>
	<h1>include2 - bottom</h1>
</body>
</html>