<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify_form.jsp</title>
</head>
<body>
${studentVo}
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					학생 정보 수정 양식
				</h2>
				<p>
					아래 항목을 빠짐 없이 작성해주세요.
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="/student/list">학생 목록</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<form role="form" action="/student/addStudent" method="post">
			
				<div class="form-group">
					 
					<label for="s_no">
						학번
					</label>
					<input type="number" class="form-control" id="s_no" name="s_no"/>
				</div>
				<div class="form-group">
					 
					<label for="s_name">
						이름
					</label>
					<input type="text" class="form-control" id="s_name" name="s_name" value="${studentVo.s_name}"/>
				</div>
				<div class="form-group">					 
					<label for="s_year">
						학년
					</label>
					<input type="number" class="form-control" id="s_year" name="s_year" value="${studentVo.s_year}"/>
				</div>
				<div class="form-group">
					 
					<label for="s_gender">
						성별
					</label>
					<input type="text" class="form-control" id="s_gender" name="s_gender" value="${studentVo.s_gender}"/>
					
				</div>
				<div class="form-group">
				
				    <label for="s_major">전공</label>
				    <select class="form-control" id="s_major" name="s_major">
				        <c:choose>
				            <c:when test="${studentVo.s_major eq '컴퓨터 공학'}">
				                <option value="컴퓨터 공학" selected>컴퓨터 공학</option>
				            </c:when>
				            <c:when test="${studentVo.s_major eq '물리학'}">
				                <option value="물리학" selected>물리학</option>
				            </c:when>
				            <c:when test="${studentVo.s_major eq '화학'}">
				                <option value="화학" selected>화학</option>
				            </c:when>
				            <c:when test="${studentVo.s_major eq '에너지공학'}">
				                <option value="에너지공학" selected>에너지공학</option>
				            </c:when>
				            <c:otherwise>
				                <!-- Default selection: 물리학 -->
				                <option value="물리학" selected>물리학</option>
				            </c:otherwise>
				        </c:choose>
				        <option value="컴퓨터 공학">컴퓨터 공학</option>
				        <option value="물리학">물리학</option>
				        <option value="화학">화학</option>
				        <option value="에너지공학">에너지공학</option>
				    </select>
				</div>
				<div class="form-group">
					 
					<label for="s_score">
						점수
					</label>
					<input type="number" class="form-control" id="s_score" name="s_score" value="${studentVo.s_score}" />
				</div>
				
				<button type="submit" class="btn btn-primary">
					작성 완료
				</button>
			</form>
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>
</body>
</html>