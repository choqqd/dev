<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearch.jsp</title>
</head>
<body>
	<h3>회 원 정 보 검 색</h3>
	<form action = "memberSearch.do">
	ID: <input type="text" name = "id"><br>
	<input type="hidden" name="job" value="search">
	<input type="submit" value="조회">
	</form>
</body>
</html>