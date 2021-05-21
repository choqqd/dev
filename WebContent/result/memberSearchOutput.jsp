<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearchOutput.jsp</title>
</head>
<body>
<h3>검색결과</h3>
<%
	MemberVO member = (MemberVO)request.getAttribute("member");
	if(member !=null){
		%>
		<p>${member.id } / ${member.name } / ${member.mail }</p>		
		<%
	}else{
		%><h3>조회 결과가 없습니다.</h3> <%
	}
%>

<a href ="index.jsp">첫 페이지</a>
</body>
</html>