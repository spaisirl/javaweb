<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//String score = request.getParameter("score");
	//int iScore = Integer.parseInt(score);
	int score = Integer.parseInt(request.getParameter("score"));
	
	
	String grade = "";
	
			if (score >= 90 && score <= 100) {
	
				 grade = "A";
	
				
			} else if (score >= 80 && score<=89) {
				
				grade = "B";	
				
			} else if (score >= 70 && score<=79) {
				
				grade = "C";
				
				
			} else if (score >= 60 && score<=69) {
				
				grade = "D";
				
			} else if (score <= 59) {
				
				grade = "E";
				
			}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scoreTest.jsp</title>
</head>
<body>

		<h1>시험점수 <%=score%></h1>
		<h1><%=grade%> 학점입니다.</h1>
	
		
	
</body>
</html>