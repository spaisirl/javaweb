<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scopeTest2.jsp</title>
</head>
<body>
	아이디: ${param.id}<br>
	bean: ${requestScope.bean}<br>
	주소: ${sessionScope.addr}<br>
	<hr>
	bean: ${bean}<br>
	주소: ${addr}
</body>
</html>