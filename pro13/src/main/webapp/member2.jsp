
<%@page import="sec01.ex01.MemberBean"%>
<%@page import="sec01.ex01.MemberDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
    
    request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memeber2.jsp</title>
</head>
<body>
	<jsp:useBean id="bean" class="sec01.ex01.MemberBean">
		
	</jsp:useBean>
	<%-- bean.setId() --%>
	<jsp:setProperty property="*" name="bean" />
	
	<%
		System.out.println(bean);
		new MemberDAO().addMember(bean);
	%>
	
	<h1>등록 완료2</h1>
	
	<%-- bean.getId() --%>
	아이디: <jsp:getProperty property="id" name="bean"/><br>
	패스워드: <jsp:getProperty property="pwd" name="bean"/><br>
	이름: <jsp:getProperty property="name" name="bean"/><br>
	이메일: <jsp:getProperty property="email" name="bean"/><br>
	
</body>
</html>