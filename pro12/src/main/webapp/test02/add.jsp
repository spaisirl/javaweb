<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/test02/addException.jsp"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));    
	int sum = 0;
	for (int i = 1; i <= num; i++) {
		sum += i;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add.jsp</title>
</head>
<body>
	<h1>1부터 <%=num %>까지의 합계: <%=sum %></h1>
</body>
</html>