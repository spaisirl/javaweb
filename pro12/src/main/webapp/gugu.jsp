<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int dan = Integer.parseInt(request.getParameter("dan"));
					
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugu.jsp</title>
<style>
	table {
		width = "500px";
	}
	th {
		background-color: yellow;
	}
	
</style>
</head>
<body>
	
	<table>
	
	<tr>
		<td colspan="2"><%=dan%>단 출력</td>
	</tr>
	
		<% 
			for (int i = 1; i<=9; i++) {
		%>
				<tr>
					<td><%=dan %>*<%=i %></td>
					<td><%=dan*i %></td>
				</tr>
		<%
			}
		%>
				
		
	</table>
		
	
</body>
</html>