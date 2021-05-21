<%@page import="com.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
	if(list.size() == 0){
		out.print("<h3>조회된 결과가 없습니다.</h3>");
	}else{
		for(MemberVO member : list){
			out.print(${member.id } / ${member.name } / ${member.mail });
		}
	}
	--%>
	<c:choose>
		<c:when test="${empty list }">
			<p>조회된 결과가 없습니다.</p>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${list}" var="member">
					<li>${member.id } - ${member.name } - ${member.mail }</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	<a href="index.jsp">첫 페이지</a>
</body>
</html>