<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/list.jsp</title>
</head>
<body>
<h3>카페 글 목록입니다.</h3>
<a href="private/insertform.do">새글쓰기</a>
<table>
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="tmp" items="${list }">
		<tr>
			<td>${tmp.num }</td>
			<td><a href="detail.do?num=${tmp.num }">${tmp.title }</a></td>
			<td>${tmp.writer }</td>
			<td>${tmp.viewCount }</td>
			<td>${tmp.regdate }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>