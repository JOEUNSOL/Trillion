<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>views/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css"/>

<style>    
     .container{
         width: 300px;
     }
     
     #block0{
        display: none;
     }
     #block{
		display: none;
	 }
	  #block2{
		display: none;
	 }
	
</style>

</head>
<body>
	
<div class="container" id="contain">  
    <div class="row">  
        
          
          
           <div class="">  
               <div class="login-box well">
               <form accept-charset="UTF-8" role="form" method="post" action="">
	              
	              <c:choose>
	              <c:when test="${not empty id }">
	                   <div>  
	                     <strong><a href="" data-toggle="modal" data-target="#myModal2">${id }</a></strong> 님 로그인중... 
		                 <a href="users/signout.do">로그아웃</a><hr />
		               </div> 
	              </c:when>
	              </c:choose>
                  <div class="form-group">
                  <c:choose>
	              <c:when test="${ empty id }">
			           <a href="" 
			           class="btn btn-default btn-block m-t-md" data-toggle="modal" data-target="#myModal"> 로그인</a>
			           <a href="" class="btn btn-default btn-block m-t-md" 
			               data-toggle="modal" data-target="#myModal3"> 회원가입</a>
			           <a href="email/write.do" class="btn btn-default btn-block m-t-md">이메일 발송</a>
			        </c:when>
	              </c:choose>    
			           <a href="cafe/private/insertform.do" class="btn btn-default btn-block m-t-md">회원 전용 카페글 쓰기</a>
			           <a href="cafe/list.do" class="btn btn-default btn-block m-t-md">카페 글 목록 보기</a>
			           <a href="shop/index.do" class="btn btn-default btn-block m-t-md">쇼핑하로 가기</a>
			           <a href="#" id="reBtn" class="btn btn-default btn-block m-t-md">취소</a>
	              </div>  
              </form>
              </div>     
         </div>   
    </div>
</div>
<!-------------------------  Modal 소스 페이지    -------------------------  -->

<!-- 동적으로 띄울 Modal 준비 -->  
<div id="myModal" class="modal fade">
    <div class="modal-dialog">
       
		    	
		   <div class="container">
		     
		
		  
		   <div class="">
			   	 <button class="close" data-dismiss="modal">&times;</button>
				<div class="login-box well">
			
                    
					<form action="signin.do?uri=${param.uri }" method="post"
						name="sForm" novalidate id="myform">
						<div class="form-group has-feedback">
							<label class="control-label" for="id">아이디</label> 
							<input class="form-control" type="text" name="id" id="id" >
							<p  id="block0" class="help-block">아이디 또는 비밀번호를 다시 확인하세요.</p>
			                <span class="glyphicon form-control-feedback"></span>
                        </div>
						<div class="form-group">
							<label for="pwd">비밀번호</label> <input class="form-control"
							type="password" name="pwd" id="pwd" />
						</div>
						<div class="form-group">
						
							<button id="id2"  type="submit" class="btn btn-default btn-block m-t-md">로그인</button>
						
						</div>
					</form>
				</div>

		</div>
	</div>
	  
	</div>
</div> 

<!-------------------------  Modal 소스 페이지    -------------------------  -->

<!-- 동적으로 띄울 Modal 준비 -->  
<div id="myModal3" class="modal">

	<div class="modal-dialog">

		<div class="modal-content">
		<button class="close" data-dismiss="modal">&times;</button>
		<h3>회원가입 폼 입니다.</h3>
        <hr />

<div class="login-box well">

		
		   
					<form action="signin.do?uri=${param.uri }" method="post"
						name="sForm" novalidate id="myform">
						<div class="form-group has-feedback">
							<label class="control-label" for="id3">아이디</label> 
							<input class="form-control" type="text" name="id" id="id3" >
							<p id="block" class="help-block">이미 사용중인 아이디 입니다.</p>
							<p id="block2" class="help-block">사용가능한 아이디 입니다.</p>
			                <span class="glyphicon form-control-feedback"></span>
                        </div>
						<div class="form-group">
							<label for="pwd">비밀번호</label> <input class="form-control"
							type="password" name="pwd" id="pwd" />
						</div>
						
						
						    
							<input type="hidden" id="senderName" name="senderName" value="김강민회사">
							<input type="hidden" id="senderMail" name="senderMail" value="fjqngodys2@gmail.com"/>
							<input name="receiveMail" id="receiveMail" /><br />
							<input type="hidden" id="subject" name="subject" value="인증번호 입니다."/>
							<input  type="hidden" id="message" name="message" value="인증번호:1234"/>
							
							
							
							
							<button id="checkBtn10">인증번호전송</button><br />
					        <span style="color:red;">${message }</span>  
							<label for="">인증</label> <input class="form-control"
							type="text" name="email" id="email" />
							<button type="submit" >인증확인</button><br />
							<button id="id2"  type="submit" class="btn btn-default btn-block m-t-md">로그인</button>
						
						
						
						
		 </form>
     </div> 
   </div> 
</div> 
</div> 


<!-- 동적으로 띄울 Modal 준비 -->
<div id="myModal2" class="modal">

	<div class="modal-dialog">

		<div class="modal-content">
		<button class="close" data-dismiss="modal">&times;</button>
			<h3>  ${id }님에 회원 정보 </h3>

<form action="">

<div class="login-box well">

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr class="">  
			<th>항목</th>
			<th>정보</th>
		</tr>
	</thead>
	<tbody>
		<tr class="">
			<th>아이디</th>
			<td>${dto.id }</td>
		</tr>
		<tr class="">
			<th>이메일</th>
			<td>${dto.email }</td>
		</tr>
		<tr class="">
		    <th>가입일</th>
		    <td>${dto.regdate }</td>
		</tr>
	</tbody>
</table>
<a href="users/private/updateform.do">가입정보 수정폼</a>
<a href="javascript:userConfirm()">회원 탈퇴</a>
</div>
</form>
		</div>
	</div>  
</div>

<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
<script>
     var a=false;
        
		$("#modalBtn").click(function(){
			$("#myModal").modal("show");
		});
		
		$("#modalBtn").click(function(){
			$("#myModal2").modal("show");
		});
		
		$("#modalBtn").click(function(){
			$("#myModal3").modal("show");
		});
		
		
	 	 $("#myform").submit(function(){
			//입력한 아이디 읽어오기
			var inputId=$("#id").val();
			var inputPwd=$("#pwd").val();
			//ajax 요청을 이용해서 서버에 전송
			
			$.ajax({
				url:"checkid.do",
				method:"get",
				data:{"inputId":inputId,"inputPwd":inputPwd},
				success:function(data){
					console.log(data);
					$("#id").parent()
					.removeClass("has-success has-error");
					if(data.canUse){
						 a=true;
						$("#id")
						.parent()
						.find(".help-block")
						.hide()
						.parent()
						.find(".glyphicon")
						.removeClass("glyphicon-remove")
						
						
						
					}else{
				  		$("#id")
						.parent()
						.addClass("has-error")
						.find("#block0")
						.show()
						.parent()
						.find(".glyphicon")
						.removeClass("glyphicon-ok")
						.addClass("glyphicon-remove");
						
						 a=false;
					}
					
				}
				
			});
			  
			 
			if(a==false){
				return false;
			}
		});
		
	 	//중복 확인 버튼을 눌렀을때 실행할 함수 등록 
	 	$("#id3").on("keyup", function(){
	 		//입력한 id 읽어오기
	 		var inputId2=$("#id3").val();
	 		//ajax 를 이용해서 서버에 전송하고 사용가능 여부 응답받기
	 		$.ajax({
	 			url:"checkid2.do",
	 			method:"get",
	 			data:{"inputId2":inputId2},
	 			success:function(data){
	 				console.log(data);
	 				$("#id3").parent()
					.removeClass("has-success has-error")
					.find(".help-block")
				    .hide();
	 				if(data.canUse){
	 					$("#id3")
						.parent()
						.addClass("has-success")
						.find("#block2")
						.show()
						.parent()
						.find(".glyphicon")
						.removeClass("glyphicon-remove")
						.addClass("glyphicon-ok");
	 				}else{
	 					$("#id3")
						.parent()
						.addClass("has-error")
						.find("#block")
						.show()
					    .parent()
						.find(".glyphicon")
						.removeClass("glyphicon-ok")
						.addClass("glyphicon-remove");
	 				}
	 			}
	 		});
	 		
	 		return false; //폼전송 막기 
	 	});
        
	 	

	 	//중복 확인 버튼을 눌렀을때 실행할 함수 등록 
		$("#checkBtn10").click(function(){
			//입력한 id 읽어오기
			
			var senderName=$("#senderName").val();
			var senderMail=$("#senderMail").val();
			var receiveMail=$("#receiveMail").val();
			var subject=$("#subject").val();
			var message=$("#message").val();
			
			//ajax 를 이용해서 서버에 전송하고 사용가능 여부 응답받기
			$.ajax({
				url:"send.do",
				method:"post",
				data:{"senderName":senderName,"senderMail":senderMail,
					"receiveMail":receiveMail,"subject":subject,"message":message},
				success:function(data){
					
				}
			});
			
			return false; //폼전송 막기 
		});

		
</script>	
</body>
</html>
   



 
















