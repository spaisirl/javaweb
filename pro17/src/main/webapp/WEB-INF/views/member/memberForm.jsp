<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록 양식</title>
<%@ include file = "/WEB-INF/views/include/bs.jsp" %>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					회원 가입
				</h2>
				<p>
					아래 항목을 빠짐 없이 작성해주세요.
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="/member/listMembers">회원 목록</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<form role="form" action="/member/addMember" method="post">
			
				<div class="form-group">
					 
					<label for="id">
						아이디
					</label>
					<input type="text" class="form-control" id="id" name="id"/>
				</div>
				<div class="form-group">
					 
					<label for="pwd">
						패스워드
					</label>
					<input type="password" class="form-control" id="pwd" name="pwd" value="${memberVO.pwd}"/>
				</div>
				<div class="form-group">					 
					<label for="name">
						이름
					</label>
					<input type="text" class="form-control" id="name" name="name" value="${memberVO.name}"/>
				</div>
				<div class="form-group">
					 
					<label for="email">
						이메일
					</label>
					<input type="text" class="form-control" id="email" name="email" value="${memberVO.email}"/>
				</div>
				<div class="form-group">
					 
					<label for="joindate">
						가입일
					</label>
					<input type="date" class="form-control" id="joindate" name="joindate" value="${memberVO.joindate}" readonly/>
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