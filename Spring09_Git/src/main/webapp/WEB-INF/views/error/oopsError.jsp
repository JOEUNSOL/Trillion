<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/error/oopsError.jsp</title>
</head>
<body>
<h3>에러 페이지 입니다.</h3>
<p>OopsException !</p>
<p> 에러 정보 : <strong>${exception.message }</strong></p>
</body>
</html>