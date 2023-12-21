<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	//선언문 : !
	String name = "듀크"; //필드(멤버변수)
	public void sayHello() {
		System.out.println("안녕하세요.");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문 연습</title>
</head>
<body>
	이름: <%=name%>
	<%
		sayHello();
	%>
</body>
</html>