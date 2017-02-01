<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<h2>이메일 쓰기</h2>
<form method="post" action="send.do">
발신자 이름 : <input name="senderName"><br />
발신자 이메일주소 : <input name="senderMail" /><br />
수신자 이메일주소 : <input name="receiveMail" /><br />
제목 : <input name="subject" /><br />
내용 : <textarea name="message" rows="5" cols="80"></textarea>
<input type="submit" value="전송" />
</form>
<span style="color:red;">${message }</span>  
</body>
</html>