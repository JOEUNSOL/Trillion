<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<style>
	#ch{
		margin-top:50px;
		width:100%;
		height:400px;
		border: 3px solid black;
		overflow: hidden;
	}
	p{
		margin-top: 0px;
		margin-bottom: 8px;
	}
	
</style>
</head>
<body >
<h3>회원 목록 페이지입니다.</h3>
<div id="ch" >
	
</div>
<div class="form-group has-feedback" >
	<label class="control-label" for="message">메세지</label>
	<input class="form-control"  type="text" name="message" id="message"   />
	<p id="help" class="help-block"  style="color: red"></p>
</div>
<button id="btn" type="button" >보내기</button>



<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.js"></script>
<script>
	
	

	 $("#message").on("keypress",function(ev){
		var sendMessage = $("#message").val();
		
		if(ev.which == 13){
			
			$.ajax({
				url:"send.do",
				method:"get",
				data:{sendMessage:sendMessage},
				
				success:function(data){
					console.log(data);
					if(data.sendMessage  == ""){
						console.log("메세지값이 비었음");
						$("#message").on("keypress",function(){
							$("#message").siblings("#help")
							.text("메세지를 입력하세요");
							})
					}else{
						console.log("메세지값이 존재함")
						$("#ch").append("<p>"+data.sendMessage+"</p>");
						$("#message").val('');
						$("#help").text("");
						
					}
				}
			})};
		})

	
		
	$("#btn").on("click",function(){
		var sendMessage = $("#message").val();
	$.ajax({
			url:"send.do",
			method:"get",
			data:{sendMessage:sendMessage},
			
			success:function(data){
				console.log(data);
				if(data.sendMessage  == ""){
					console.log("메세지값이 비었음");
					$("#btn").on("click",function(){
						$("#message").siblings("#help")
						.text("메세지를 입력하세요");
					})
				}else{
					console.log("메세지값이 존재함")
					$("#ch").append("<p>"+data.sendMessage+"</p>");
					$("#message").val('');
					console.log("메세지 전송완료")
					$("#help").text("");
					
				}
			}
		});
	});

	
	$("#message").on("keyup",function(){
		var Exist = $("#message").val();
		if(Exist == ''){
			console.log("하이");
			$("#message").siblings("#help").show();
		}else{
			$("#message").siblings("#help").hide();
		}
	})
	$("#btn").on("click",function(){
		var Exist = $("#message").val();
		if(Exist == ''){
			console.log("하이");
			$("#message").siblings("#help").show();
		}else{
			$("#message").siblings("#help").hide();
		}
	})
	$("#ch").on("scroll",function(){
		console.log(this.scrollTop);
	})
</script>
</body>
</html>