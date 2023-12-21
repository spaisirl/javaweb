<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json5.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	$(function() {
		$("button").click(function() {
			$.get("/Json", function(rData) {
				console.log("rData:", rData);
				var tableTag = "<table border='1'>";
				tableTag += "<tr>";
				tableTag += "	<th>아이디</th>";
				tableTag += "	<th>비밀번호</th>";
				tableTag += "	<th>이름</th>";
				tableTag += "	<th>이메일</th>";
				tableTag += "	<th>가입일</th>";
				tableTag += "</tr>";
				
				for (var v = 0; v < rData.members.length; v++) {
					var member = rData.members[v];
					tableTag += "<tr>";
					tableTag += "	<td>" + member.id + "</td>";
					tableTag += "	<td>" + member.pwd + "</td>";
					tableTag += "	<td>" + member.name + "</td>";
					tableTag += "	<td>" + member.email + "</td>";
					tableTag += "	<td>" + member.joindata + "</td>";
					tableTag += "</tr>";
				}
				
				
				tableTag += "</table>"
				
				$("#resultDiv").html(tableTag);
				
			});			
		});
	});
</script>
</head>
<body>
	<button>버튼</button>
	<div id ="resultDiv"></div>
</body>
</html>