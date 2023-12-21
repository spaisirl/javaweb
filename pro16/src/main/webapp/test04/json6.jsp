<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json6.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
//모델1 방식 - 브라우저에서 jsp요청 -> .java를 가져다 쓴다.
	$(function() {
		$("button").click(function() {
			$.get("/json2", function(rData) {
				console.log($("#resultDiv tbody > tr:eq(0)"));
				
				
				for (var v = 0; v < rData.members.length; v++) {
					var member = rData.members[v];
					//테이블에 접근해서 tr의 N번째 컬럼에 접근
					var trTag = $("#resultDiv tbody > tr:eq(0)").clone(); 
					console.log("trTag:", trTag);
					var tds = trTag.find("td");
					tds.eq(0).text(member.id);
					tds.eq(1).text(member.pwd);
					tds.eq(2).text(member.name);
					tds.eq(3).text(member.email);
					tds.eq(4).text(member.joindate);
					$("#resultDiv tbody").append(trTag);
				}

				$("#resultDiv tbody > tr:eq(0)").remove();
				
				$("#resultDiv").fadeIn(3000);
				
				
				
			});			
		});
	});
</script>
</head>
<body>
	<button>버튼</button>
	<div id ="resultDiv" style="display:none;">
		<table border="1">
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	
</body>
</html>