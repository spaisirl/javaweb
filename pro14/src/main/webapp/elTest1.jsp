<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest1.jsp</title>
</head>
<body>

 <div>\${100} : ${100}</div>
 <div>${"안녕하세요"}</div>
 <div>${'안녕하세요'}</div>
 
 <div>${1+2}</div>
 <div>${1/2}</div>
<!-- <div>${1 div 2}</div> --> 
 <div>${1 mod 2}</div>
 <div>${"1" + 2}</div>
 <div>\${"일" + 2}</div>
 <div>\${"일" + "이"}</div>
 
 <!-- 비교연산자 -->
 
 <div>${1> 2 }</div>
 <div>${1 gt 2 }</div>
 <div>${1 ge 2 }</div>
 <div>${1 eq 2 }</div>
 <!-- <div>${1 ne 2 }</div> -->
 <div>${1 != 2 }</div>
 <div>${1 <= 2 }</div>
 
 <!-- 논리연산자 -->
 <div>${1 == 2 && 3 ==4 }</div>
 <div>${(1 eq 2) and (3 eq 4) }</div>
 <div>${!true }</div>
 <div>${ not true }</div>
 <hr>
 <jsp:useBean id="bean" class="sec01.ex01.MemberBean"></jsp:useBean>
 <jsp:setProperty property="id" name="bean" value=""/>
 <div>${bean}</div>
 <div>${empty bean.id}</div>
 <div>${empty bean.pwd}</div>
 <div>${not empty bean.name}</div>
 
</body>
</html>