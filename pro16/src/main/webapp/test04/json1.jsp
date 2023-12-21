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
			var jsonStr = '{"name": ["홍길동", "이순신", "임꺽정"]}';
			var jsonAge = '{"age" : [20, 30, 40]}';
			
			console.log("jsonStr:" + jsonStr);
			var jsonObj = JSON.parse(jsonStr);
			var jsonObj2 = JSON.parse(jsonAge); // 중요!
			console.log("jsonObj:" , jsonObj);
 			console.log(jsonObj.name);
			var ulTag = "<ul>";
 			for (var v = 0; v < jsonObj.name.length; v++) {
				ulTag += "			<li>" + jsonObj.name[v] + ":" + jsonObj2.age[v] + "</li>";
			}
			ulTag += "</ul>";
			$("#resultDiv").append(ulTag);
		});
	});
</script>
</head>
<body>
	<button>버튼</button>
	<div id ="resultDiv"></div>
</body>
</html>