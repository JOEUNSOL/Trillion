<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<style>
	body{
	 background: linear-gradient(0deg, rgba(6, 242, 164, .5), rgba(255,255, 255, .5)) fixed, url("http://www.durhambungalows.ca/images/20617/Spring.jpg") fixed;


		background-repeat: no-repeat;
		background-size: cover;
	}
	.page_display{
		text-align: center;
	}
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
	*{
		text-align: center;
	}
</style>
</head>
<body>
<h3>카페 글 목록입니다.</h3>
<a href="private/insertform.do">새글쓰기</a>
<table class="table">
	<thead>
		<tr>
			<th style="text-align: center;">글번호</th>
			<th style="text-align: center;">제목</th>
			<th style="text-align: center;">작성자</th>
			<th style="text-align: center;">조회수</th>
			<th style="text-align: center;">등록일</th>
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
<ul class="pagination">
	<c:choose>
		<c:when test="${startPageNum ne 1 }">
			<li><a href="list.do?pageNum=${startPageNum-1 }">[ 이전 ]</a></li>
		</c:when>
		<c:otherwise>
			<li><a class="muted" href="javascript:">[ 이전 ]</a></li>
		</c:otherwise>
	</c:choose>

	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${i eq pageNum }">
				<li><a class="active" href="list.do?pageNum=${i }">${i }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="list.do?pageNum=${i }">${i }</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${endPageNum lt totalPageCount }">
			<li><a href="list.do?pageNum=${endPageNum+1 }">[ 다음 ]</a></li>
		</c:when>
		<c:otherwise>
			<li><a class="muted" href="javascript:">[ 다음 ]</a></li>
		</c:otherwise>
	</c:choose>
	</ul>
</div>
<!-- 검색어 관련 form -->
<form action="list.do" method="post" id="keywordForm">
	<label for="condition">검색 조건</label>
	<select name="condition" id="condition">
		<option value="titlecontent" <c:if test="${condition eq 'titlecontent' }">selected</c:if>>제목+내용</option>
		<option value="title" <c:if test="${condition eq 'title' }">selected</c:if>>제목</option>
		<option value="writer" <c:if test="${condition eq 'writer' }">selected</c:if>>작성자</option>
	</select>
	<input type="text" name="keyword" placeholder="검색어" 
		value="${keyword }"/>
	<button type="submit">검색</button>
</form>
</body>
</html>







