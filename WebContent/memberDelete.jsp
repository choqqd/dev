<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회 원 정 보 검 색</h3>
	<form action = "memberSearch.do">
	ID: <input type="text" name = "id"><br>
	<input type="hidden" name="job" value="delete">
	<input type="submit" value="조회">
	</form>
	<%
	MemberVO member = (MemberVO)request.getAttribute("member");
	if(member!=null){
		//출력화면
	%>
	<p>Id: <%=member.getId() %> / name: <%=member.getName()%> / Mail: <%=member.getMail() %> </p>
	<form action="memberDelete.do" method="post">
		<input type="hidden" name="id" value="<%=member.getId() %>"><br>
		<input type="submit" value="삭제">
	</form>
	
	<%
	}else{// 결과가없을때
	%>
	<h3>조회 결과가 없습니다.</h3>
	<%
	}
	 %>
</body>
</html>