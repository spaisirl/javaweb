<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlTest</title>
</head>
<body>
	<c:set var="id" value="lee"></c:set>
	<c:set var="pwd" value="1234"></c:set>
	아이디: ${id}<br>
	패스워드: ${pwd}
	<hr>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	컨텍스트 경로: ${contextPath}
	
	<%-- 조건문 --%>
	<c:if test="${id == 'hong'}">
		<div>아이디는 hong입니다.</div>
	</c:if>
	
	<hr>
	
	<c:choose>
		<c:when test="${id== 'hong'}">
			<div>아이디는 hong입니다.</div>
		</c:when>
		<c:when test="${id == 'kim'}">
			<div>아이디는 kim입니다.</div>
		</c:when>
		<c:otherwise>
			<div>아이디가 hong도 kim도 아닙니다.</div>
		</c:otherwise>
	</c:choose>
	
	<hr>

	<%-- 반복문 --%>
	
	<c:forEach var="i" begin="1" end="10" step="2">
		<div>${i}</div>
	</c:forEach>
	<hr>
	<%
		List<String> strings = new ArrayList<>();
		strings.add("A");
		strings.add("B");
		strings.add("C");
		pageContext.setAttribute("strings", strings);
	%>
	
	<%-- for(String str : strings) --%>
	<c:forEach var="str" items="${strings}" varStatus="status">
		<div>
		<span style="color:red;">${status.index}</span>
		<span style="color:blue;">${status.count}</span>
		<span>${str}</span>
		</div>
	</c:forEach>
	
	
	
</body>
</html>