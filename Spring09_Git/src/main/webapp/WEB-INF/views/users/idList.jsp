<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#ch{
		margin-top:50px;
		width:300px;
		height:400px;
		border: 3px solid black;
	}
	p{
		margin-top: 7px;
		margin-bottom: 7px;
	}
</style>
</head>
<body>
<h3>회원 목록 페이지입니다.</h3>
<div id="ch">
	<p>호놀룰루</p>
	<p>란랄루</p>
</div>
<label for="message">메세지</label>
<input type="text" name="message" id="message" />
<button id="btn" type="submit">보내기</button>



<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.js"></script>
<script>
	$("#btn").on("click",function(){
			var sendMessage = $("#message").val();
	$.ajax({
			url:"send.do",
			method:"get",
			data:{sendMessage:sendMessage},
			
			success:function(data){
				console.log(data);
				if(data){
					$("#ch").add
				}else{
					
				}
			}
		});
	});
</script>
</body>
</html>