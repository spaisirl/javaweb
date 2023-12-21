<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    	String name = request.getParameter("name");
    	String imgName = request.getParameter("imgName");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result.jsp</title>
</head>
<body>
	<h1>이름 <%=name %></h1>
	<img src="/image/<%=imgName %>">
</body>
</html>