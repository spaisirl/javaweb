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
			var jsonStr = '{"name": "박지성", "age":25, "gender":"남자", "nickname":"날쌘돌이"}';
			var jsonObj = JSON.parse(jsonStr);
			console.log("jsonObj:", jsonObj.name);
			//console.log("name:", name);
			var ulTag = "<ul>";
			ulTag += "			<li>" + "이름:" + jsonObj.name +"</li>"
			ulTag += "			<li>" + "나이:" + jsonObj.age +"</li>"
			ulTag += "			<li>" + "성별:" + jsonObj.gender +"</li>"
			ulTag += "			<li>" + "별명:" + jsonObj.nickname +"</li>"
			ulTag += "</ul>";
			
			$('#resultDiv').append(ulTag);
		});
	});
</script>
</head>
<body>
	<button>버튼</button>
	<div id ="resultDiv"></div>
</body>
</html>