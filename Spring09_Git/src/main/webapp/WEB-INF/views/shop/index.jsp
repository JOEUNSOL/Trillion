<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/shop/index.jsp</title>
</head>
<body>
<h3>Gura 쇼핑몰 입니다.</h3>
<h3>공지 사항</h3>
<ul>
	<c:forEach var="tmp" items="${info }">
		<li>${tmp}</li>
	</c:forEach>
</ul>
<h3>메뉴</h3>
<ul>
	<li><a href="depositform.do">입금하러 가기</a></li>
	<li><a href="list.do">상품 목록 보러 가기</a></li>
</ul>
</body>
</html>






