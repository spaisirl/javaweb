<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String user_id = request.getParameter("user_id");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginTest.html</title>
</head>
<body>
<form name="myForm" action="/loginTest" method="post">
	<label for="user_id">아이디:</label>
	<input type="text" id="user_id" name="user_id" value="<% out.print(user_id); %>">
	<br>
	<label for="user_pw">패스워드:</label>
	<input type="password" id="user_pw" name="user_pw">
	<br>
	<button type="submit">로그인</button>
	<button type="reset">다시작성</button>
</form>
<script>
	function fn_view() {
		var user_id = document.querySelector("user_id");
		var user_pw = document.querySelector("user_pw");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("</head>")
		sb.append("<body>");
		
		if (user_id == null || user_id.lenth() == 0) {
			sb.append("<div>아이디를 입력해주세요.</div>");	
			return;
					
		} else if (user_pw == null || user_pw.lenth() == 0) {
			sb.append("<div>비밀번호를 입력해주세요.</div>");
			
		} else if (user_id.equals("admin") && user_pw.equals("1234")) {
			
			sb.append("<h1>관리자로 로그인하셨습니다.</h1>");
			sb.append("<button type='button'>회원정보 수정하기</button>");
			sb.append("<button type='button'>회원정보 삭제하기</button>");
			
		}else  {
			
			if (user_id == "lee" && user_pw == "1234") {
			
				sb.append("<div>" + user_id + "님 로그인완료.</div>");
			
			}
		}
		
		sb.append("<a href='test01/login.jsp?user_id=" + user_id + ">로그인창으로 이동</a>")
		sb.append("</body>")
		sb.append("</html>")
		
		response.setContentType("text/html;charset=uft-8");
		PrintWriter writer = response.getWriter();
		
		writer.println(html);
		
		
	}
	
	
</script>
</body>
</html>