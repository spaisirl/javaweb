<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/*	
		if (id != null && id.length() > 0) {
			out.print("<h1>" + id + "님 반갑습니다.</h1>");
		} else {
			out.print("<a href='/login.html'>로그인 창으로 이동</a>");
		}
		*/
		
		if (id != null && id.length() > 0) {
			
	%>
		<h1><%=id %>님 반갑습니다.</h1>
	<%
		} else {
	%>
			<a href="/login.html">로그인 창으로 이동</a>
	<%
		}

	%>
</body>
</html>