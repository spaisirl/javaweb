<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	request.setCharacterEncoding("utf-8"); // post 요청에 대한 한글처리
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
 <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        $(function() {
            // 수정
            $(".btn-warning").click(function() {
                console.log("수정버튼");
                var id = $(this).attr("data-id");
                console.log(id);
                var url = "/student/modify_form?s_no=" + id;
                self.location = url;
            });

            // 삭제
            $(".btn-danger").click(function() {
                var id = $(this).attr("data-id");
                console.log(id);
                var url = "/student/delete?s_no=" + id;
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
					학생 관리 프로그램
				</h2>
				
				<p>
					<a class="btn btn-primary btn-large" href="/student/register_form">학생 등록</a>
				</p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>학번</th>
						<th>이름</th>
						<th>학년</th>
						<th>성별</th>
						<th>전공</th>
						<th>점수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="studentVo" items="${list}">
							<tr>
								<td>${studentVo.s_no}</td>
								<td>${studentVo.s_name}</td>
								<td>${studentVo.s_year}</td>
								<td>${studentVo.s_gender}</td>
								<td>${studentVo.s_major}</td>
								<td>${studentVo.s_score}</td>
								<td><button type="button" class="btn-warning" data-id="${studentVo.s_no}">수정</button></td>
								<td><button type="button" class="btn btn-danger" data-id="${studentVo.s_no}">삭제</button></td>
							</tr>
						</c:forEach>
		
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>
	<% session.removeAttribute("result"); %>