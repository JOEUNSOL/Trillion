<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/home.jsp</title>
</head>
<body>
<h3>인덱스 페이지 입니다.</h3>
<c:choose>
	<c:when test="${empty id }">
		<div>
			<a href="users/signin_form.do?uri=${pageContext.request.contextPath }">로그인</a>
			<a href="users/signup_form.do">회원가입</a>
		</div>
	</c:when>
	<c:otherwise>
		<div>
			<strong><a href="users/private/info.do">${id }</a></strong> 님 로그인중 ...
			<a href="users/signout.do">로그아웃</a>
		</div>
	</c:otherwise>
</c:choose>
</body>
</html>



