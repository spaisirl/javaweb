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
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="bean" class="sec01.ex01.MemberBean">
		
	</jsp:useBean>
	<%-- bean.setId() --%>
	<jsp:setProperty property="id" name="bean" value='<%=request.getParameter("id") %>'/>
	<jsp:setProperty property="pwd" name="bean" value='<%=request.getParameter("pwd") %>'/>
	<jsp:setProperty property="name" name="bean" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty property="email" name="bean" value='<%=request.getParameter("email") %>'/>
	<%
		System.out.println(bean);
		new MemberDAO().addMember(bean);
	%>
	
	<h1>등록 완료</h1>
	
</body>
</html>