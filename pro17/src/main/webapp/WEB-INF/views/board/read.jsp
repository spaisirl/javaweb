<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "/WEB-INF/views/include/bs.jsp" %>
<script>
$(function() {
	var updateResult = "${updateResult}";
	if (updateResult == "true") {
		alert("글 수정 성공");	
	} else if (updateResult == "false") {
		alert("글 수정 실패");
	}
	
	
	$("#btnModify").click(function() {
		$(".mod").prop("readonly", false);
		$(this).fadeOut(1000);
		$("#btnModifyFinish").fadeIn(1000);
	});
	$("#btnDelete").click(function() {
		console.log("삭제");
		var resulteDelete = confirm("삭제하시겠습니까?"); // confirm : 확인창
		console.log("resulteDelete", resulteDelete);
		if (resulteDelete == true) {
			var bno = ${boardVO.bno};
			console.log("bno", bno);
			var url = "/board/delete?bno=${boardVO.bno}";
			self.location=url;
		}
		
	});
});
</script>
</head>
<body>
	<h1>read</h1>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2># ${boardVO.bno}</h2>
				<p>
					아래에서 작성한 글을 읽어주세요.
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="/board/list">글 목록 이동</a>
				</p>
			</div>
			<form role="form" action="/board/modifyRun" method="post">
			<input type="hidden" name="bno" value="${boardVO.bno}"/>
				<div class="form-group">
					 
					<label for="title">
						글제목
					</label>
					<input type="text" class="form-control mod" id="title" name="title" 
						value = "${boardVO.title}" readonly/>
				</div>
				<div class="form-group">
					 
					<label for="content">
						글내용
					</label>
					<textarea class="form-control mod" id="content" name="content" readonly>${boardVO.content}</textarea>
				</div>
				
				<div class="form-group">
					 
					<label for="writer">
						작성자
					</label>
					<input type="text" class="form-control" id="writer" 
						value = "${boardVO.writer}" readonly/>
				</div>
				
				<div class="form-group">
					 
					<label for="writer">
						첨부파일
						<c:choose>
							<c:when test="${fn:endsWith(boardVO.attach_file, '.png') or fn:endsWith(boardVo.attach_file, '.jpg') or fn:endsWith(boardVO.attach_file, '.gif')}">
								<img src="/download?attach_file=${boardVO.attach_file}">
							</c:when>
						<c:otherwise>
							<img src="/images/default.png" height="100">
						</c:otherwise>
						</c:choose>
					</label>
					
				</div>
				
				<div class="form-group">
					 
					<label for="regdate">
						작성일
					</label>
					<input type="text" class="form-control" id="regdate"
						value = "${boardVO.regdate}" readonly/>
				</div>				
				
				<button type="button" class="btn btn-warning" 
					id="btnModify">수정</button>
				<button type="submit" class="btn btn-success" 
					id="btnModifyFinish" style="display:none">수정완료</button>
				<button type="button" class="btn btn-danger" id="btnDelete">삭제</button>
				
			</form>
		</div>
	</div>
</div>
</body>
</html>
<% session.removeAttribute("updateResult"); %>