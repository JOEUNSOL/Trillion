<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>

</head>
<body>
<div id="one">호우형</div>
<form action="" method="">
<input type="text" name="text" id="text" />
<button type="submit">전송</button>
</form>



<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.js"></script>
<script>
	$("#one").on("click",function(){
		var text = $("#text").val();
		$.ajax({
			url:"lab.do",
			method:"get",
			data:{text:text},
			success:function(data){
				console.log(data);
			}
		})
	})
</script>
</body>
</html>