<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<h3>파일 목록 입니다.</h3>
<a href="insertform.do">파일 업로드</a>
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>파일명</th>
			<th>크기</th>
			<th>등록일</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="tmp" items="${list }">
		<tr>
			<td>${tmp.num }</td>
			<td>${tmp.writer }</td>
			<td>${tmp.title }</td>
			<td><a href="download.do?num=${tmp.num }">${tmp.orgFileName }</a></td>
			<td>${tmp.fileSize }</td>
			<td>${tmp.regdate }</td>
			<td><a href="delete.do?num=${tmp.num }">삭제</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>