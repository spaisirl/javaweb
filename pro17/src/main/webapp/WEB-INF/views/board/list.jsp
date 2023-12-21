<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "/WEB-INF/views/include/bs.jsp" %>
<script>
	var resulteDelete = "${sessionScope.deleteResult}"
	if (resulteDelete == "true") {
		alert("삭제 성공");
	} else if (resulteDelete == "false") {
		alert("삭제 실패")
	}
</script>
</head>
<body><div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					글목록
				</h2>
				<p>
					글 목록
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="/board/writeForm">글쓰기</a>
				</p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>파일명</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="boardVO" items="${list}">
					<tr>
						<td>${boardVO.bno}</td>
						<!-- list 에서 글 제목을 클릭하면 글번호를 불려들여 와서 글을 읽을 수 있다.  -->
						<td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td>
						<td>${boardVO.writer}</td>
						<td>${boardVO.regdate}</td>
						<td>${boardVO.attach_file}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>
<% session.removeAttribute("ResulteDelete"); %>