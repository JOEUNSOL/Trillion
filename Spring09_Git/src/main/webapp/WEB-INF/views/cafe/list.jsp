<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/list.jsp</title>
<style>
	.page_display a{
		text-decoration: none;
		color: #000;
	}
	.page_display a.active{
		font-weight: bold;
		color: red;
		text-decoration: underline;
	}
	
	.page_display a.muted{
		color: #cecece;
	}
</style>
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
<!-- 페이지 디스플레이 출력 -->
<div class="page_display">
	<c:choose>
		<c:when test="${startPageNum ne 1 }">
			<a href="list.do?pageNum=${startPageNum-1 }">[ 이전 ]</a>
		</c:when>
		<c:otherwise>
			<a class="muted" href="javascript:">[ 이전 ]</a>
		</c:otherwise>
	</c:choose>

	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${i eq pageNum }">
				<a class="active" href="list.do?pageNum=${i }">${i }</a>
			</c:when>
			<c:otherwise>
				<a href="list.do?pageNum=${i }">${i }</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${endPageNum lt totalPageCount }">
			<a href="list.do?pageNum=${endPageNum+1 }">[ 다음 ]</a>
		</c:when>
		<c:otherwise>
			<a class="muted" href="javascript:">[ 다음 ]</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>







