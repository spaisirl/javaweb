<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json1.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	$(function() {
		$("button").click(function() {
			var jsonStr = '{"member" : [{"name":"박지성", "age":25, "gender":"남자", "nickname":"날쌘돌이"},';
			jsonStr += '{"name":"손흥민", "age":31, "gender":"남자", "nickname":"쏘니"},';
			jsonStr += '{"name":"황희찬", "age":26, "gender":"남자", "nickname":"차니"}]}';
			var jsonObj = JSON.parse(jsonStr);
			console.log("jsonObj:" , jsonObj);
			console.log("member:", jsonObj.member); // []
			console.log("member[0]:", jsonObj.member[0]); // {}
			console.log("member[0].name:", jsonObj.member[0].name);
			console.log("member[0].age:", jsonObj.member[0].age);
			console.log("member[1].name:", jsonObj.member[1].name);
			var member = jsonObj.member;
			for (var v = 0; v < member.length; v++) {
				var olTag = "<ol>";
				olTag +=  "		<li>" + "이름:" + member[v].name + "</li>"; 
				olTag +=  "		<li>" + "나이:" + member[v].age + "</li>"; 
				olTag +=  "		<li>" + "성별:" + member[v].gender + "</li>"; 
				olTag +=  "		<li>" + "별명:" + member[v].nickname + "</li>"; 
				olTag += "</ol>";
				console.log("olTag:", olTag)
				
				$('#resultDiv').append(olTag);
			}

		});
	});
</script>
</head>
<body>
	<button>버튼</button>
	<div id ="resultDiv"></div>
</body>
</html>