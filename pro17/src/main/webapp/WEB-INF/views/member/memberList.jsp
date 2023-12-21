<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<%@ include file="/WEB-INF/views/include/bs.jsp" %>		
<script>

$(function() {
	var result = "${sessionScope.result}";
	if (result == "true") {
		alert("회원 정보 수정 성공");
	} else if(result == "false") {
		alert("회원 정보 수정 실패");
	}
	
	//수정
	$(".btn-warning").click(function() {
		console.log("수정버튼");
		var id = $(this).attr("data-id");
		console.log(id);
		var url ="/member/modifyForm?id=" + id;
		self.location = url;
		
	});
	
	//삭제
	$(".btn-danger").click(function() {
// 		var id = $(this).parent().parent().find("td").eq(0).text();
// 		console.log(id);
		//속성 .attr()
		var id = $(this).attr("data-id");
		console.log(id);
		var url = "/member/delMember?id=" + id;
		self.location = url;
	});
		
});
</script>					
</head>
<body>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					회원 목록
				</h2>
				<p>
					안녕하세요, 가입 된 회원 목록 입니다.
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="/member/memberForm">회원 가입</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<table class="table">
				<thead>
						<tr>
							<th>아이디</th>
							<th>패스워드</th>
							<th>이름</th>
							<th>이메일</th>
							<th>가입일</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
				<tbody>
				<c:forEach var="vo" items="${memberList}">
							<tr>
								<td>${vo.id}</td>
								<td>${vo.pwd}</td>
								<td>${vo.name}</td>
								<td>${vo.email}</td>
								<td>${vo.joindate}</td>
								<td><button type="button" class="btn btn-warning" data-id="${vo.id}">수정</button></td>
								<td><button type="button" class="btn btn-danger" data-id="${vo.id}">삭제</button></td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>
</body>
</html>
	<% session.removeAttribute("result"); %>