<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scopeTest1.jsp</title>
</head>
<body>
	<jsp:useBean id="bean" class="sec01.ex01.MemberBean"></jsp:useBean>
	<jsp:setProperty property="*" name="bean"/>
	<%
		request.setAttribute("bean", bean);
		session.setAttribute("addr", "울산시 남구");
	%>
	<jsp:forward page="/scopeTest2.jsp"></jsp:forward>
</body>
</html>