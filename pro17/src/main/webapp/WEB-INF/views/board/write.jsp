<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/write.jsp</title>
<%@ include file="/WEB-INF/views/include/bs.jsp" %>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					글쓰기
				</h2>
				
				<p>
					<a class="btn btn-primary btn-large" href="/board/list">목록으로</a>
				</p>
			</div>
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<form role="form" action="/board/writeRun" method="post" enctype="multipart/form-data">
						<div class="form-group">
							 
							<label for="title">
								글제목
							</label>
							<input type="text" class="form-control" id="title"
								name="title" />
						</div>
						<div class="form-group">
							 
							<label for="content">
								글내용
							</label>
							<textarea class="form-control" id="content"
								name="content"></textarea>
						</div>
						<div class="form-group">
							 
							<label for="writer">
								작성자
							</label>
							<input type="text" class="form-control" id="writer"
								name="writer" />
						</div>
						
						<div class="form-group">
							 
							<label for="file">
								파일 업로드
							</label>
							<input type="file" class="form-control-file" id="file"
								name="file" />
							<p class = "help-block">
								업로드 할 파일을 선택하세요.
							</p>
						</div>			
						<button type="submit" class="btn btn-primary">
							작성완료
						</button>
					</form>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>