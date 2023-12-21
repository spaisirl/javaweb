<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	//선언문 : !
	String name = "듀크"; //필드(멤버변수)
	public void sayHello() {
		System.out.println("안녕하세요.");
	}
	
	public String getName() {
		return name;
	}
%>
<%
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문 연습</title>
</head>
<body>
	이름: <%=getName()%><br>
	<%
		sayHello();
	%>
	나이: <%=age%>
	
	<!-- HTML 주석입니다. -->
	<%--JSP 주석입니다. (소스유출x)--%> 
	
</body>
</html>