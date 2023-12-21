<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>collectionTest1.jsp</title>
</head>
<body>
<%
	MemberBean bean1 = new MemberBean("1", "2", "3", "4@4", null);
	MemberBean bean2 = new MemberBean("홍길동", "1", "1", "4@4", null);
	List<MemberBean> list = new ArrayList<>();
	list.add(bean1);
	list.add(bean2);
	pageContext.setAttribute("list", list);
	
	Map<String, MemberBean> map = new HashMap<>();
	map.put("1", bean1);
	map.put("2", bean2);
	pageContext.setAttribute("map", map);
	
%>
	${list}<hr>
	아이디: ${list[0].id}, ${list[1].id}<br>
	패스워드: ${list[0].pwd}, ${list[1].pwd}<br>
	이름: ${list[0].name}, ${list[1].name}<br>
	이메일: ${list[0].email}, ${list[1].email}<br>
	<hr>
	${map}
	<hr>
	${map["1"]}
	<hr>
	${map["1"].id}
</body>
</html>