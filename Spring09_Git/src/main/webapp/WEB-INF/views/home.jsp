<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<style>
	body{
		 background: linear-gradient(180deg, rgba(6, 242, 164, .5), rgba(255,255, 255, .5)) fixed, url("https://wallpaperscraft.com/image/march_flowers_spring_patterns_butterflies_100634_1680x1050.jpg") fixed;
		 background-repeat: no-repeat;
		 background-size: cover;
	}
	*{
		text-align: center;
		list-style-type: none;
	}
	ul{
		margin:0px;
		padding: 0px;
		
	}
</style>
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
<ul>
	<li><a href="cafe/list.do">카페 글 목록 보기</a></li>
	<li><a href="shop/index.do">쇼핑</a></li>
	<li><a href="file/fileList.do">저장소</a></li>
</ul>
</body>
</html>















