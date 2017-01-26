<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<style>
		#myCanvas{
			border: 1px solid black;
		}
		#myScore{
			border: 1px solid red;
			
			position: 50% 50%;
			font-size: 100px;
			position: absolute;
			/*top: -50px;
			left: -50px;*/

		}
		#wrapper{
			display: inline;
			position: relative;
			border: 1px solid black;
		}
		
		#scoreBoard{
			position: absolute;
			top: 30% ;
			left: 50%;
		}
	</style>
</head>
<body>
<c:choose>
	<c:when test="${empty id } ">
	<div> <strong id="hell">익명의 사용자</strong> 님 로그인 하셨습니다 </div>
</c:when>
<c:otherwise>
	<div> <strong id="hell">${id }</strong> 님 로그인 하셨습니다 </div>
</c:otherwise>
</c:choose>


<div id="scoreBoard">
	<c:forEach var="tmp" items="${list }">
		<div>${tmp.id }님의 점수 :   ${tmp.score }</div>
	</c:forEach>
</div>	
	
	
	
	<canvas id="myCanvas" width="500px" height="700px"></canvas>
	<div id="wrapper">
		<span id="myScore">Score:</span>
	</div>








<script>

//아이디 등 설정!
var myId = document.querySelector("#hell").innerText;
console.log(myId);




var canvas = document.querySelector("#myCanvas");
	var context=canvas.getContext("2d");

	//이미지 로딩하기




	var backbg=new Image();
	backbg.src="${pageContext.request.contextPath }/resources/images/01_iron_man_2.jpg";

	// 적기 이미지 로딩하기
	var player1 =new Image();
	player1.src="${pageContext.request.contextPath }/resources/images/leftInput.png";
	var player2 =new Image();
	player2.src="${pageContext.request.contextPath }/resources/images/upInput.png";
	var player3 =new Image();
	player3.src="${pageContext.request.contextPath }/resources/images/downInput.png";
	var player4 =new Image();
	player4.src="${pageContext.request.contextPath }/resources/images/rightInput.png";

	var juck1=new Image();
	juck1.src="${pageContext.request.contextPath }/resources/images/leftArrow.jpg";
	var juck2=new Image();
	juck2.src="${pageContext.request.contextPath }/resources/images/upArrow.jpg";
	var juck3=new Image();
	juck3.src="${pageContext.request.contextPath }/resources/images/downArrow.jpg";
	var juck4=new Image();
	juck4.src="${pageContext.request.contextPath }/resources/images/rightArrow.jpg";
	var juckImg = [juck1,juck2,juck3,juck4];
	
	//적기의 x 좌표 종류
	var juckX=[100, 200, 300,400];
	var juckList=[];   //{x:,y:, isDead:, energy:, type:}

	var life1 = new Image();
	life1.src = "${pageContext.request.contextPath }/resources/images/redbird.png";
	var lifeList=[];
	var lifeXloc = [0,50,100,150];
	

	var count=0;
	var score=0;
	var velocity=0;

	setInterval(drawScreen, 20);

	lifeMaker();
	alert();

// 	var sound = new Audio("sounds/xxx.mp3");
// sound.currentTime=0;
// // sound.play();

	function lifeMaker(){
		for (var i = 0; i < 4; i++) {
			
		
		
		lifeList.push(lifeXloc[i]);
		}
	};

	function drawScreen(){
		count++

		//유닛 이미지를 그려준다.
		//context.clearRect(0,0,500,800);
		context.drawImage(backbg,0,0,500,700);

		context.drawImage(player1,50,500,100,100);
		context.drawImage(player2,150,500,100,100);
		context.drawImage(player3,250,500,100,100);
		context.drawImage(player4,350,500,100,100);

		for (var i = 0; i < lifeList.length; i++) {
			
			context.drawImage(life1,lifeXloc[i] , 0, 50,50);
		}

		// context.drawImage(lifeList[0],0,0,50,50);
		// context.drawImage(lifeList[1],50,0,50,50);
		// context.drawImage(lifeList[2],100,0,50,50);
		// context.drawImage(lifeList[3],150,0,50,50);
		

		// 반복문 돌면서 적기 이미지를 그린다.
		for (var i = 0; i < juckList.length; i++) {
			var tmp=juckList[i];
			context.drawImage(juckImg[tmp.type], tmp.x-50, tmp.y-50, 100,100);
		};

		makeEnemy();
		moveEnemy();
		// enemyCheck();
		checkEnemy();
		gameOver();
		
		document.querySelector("#myScore").innerText = "Score: "+score;

};

	function gameOver(){
		if(lifeList.length==0){
			alert(" GAVEOVER! 당신의 스코어:" + score);
			//location.reload(); //새로 고침
			// 정호석 스프링 용 추가!
			
				location.href = "${pageContext.request.contextPath }/game/insert.do?id="+myId+"&score="+score;
			
			
			
			


		}
	};

	

	function makeEnemy(){
		if(count%25!=0){
			return;
		}
		var juckXloc = juckX[parseInt(Math.random()*4)];
		var juckY = 50;
		var energy = 100;
		var isDead = false;
		var type;
		if(juckXloc == 100){
			type = 0;
		}
		if(juckXloc == 200){
			type = 1;
		}
		if(juckXloc == 300){
			type = 2;
		}
		if(juckXloc == 400){
			type = 3;
		}
		var obj = {x:juckXloc , y:juckY , hp:energy,type:type
		};
		juckList.push(obj);
	};

	function moveEnemy(){
		for (var i = 0; i < juckList.length; i++) {
			var tmp =  juckList[i];
			tmp.y += 12;  //velocity
			if(tmp.y >850){ //아래쪽으로 화면을 벗어 났다면
				tmp.isDead = true;  //배열에서 제거 될수 있도록 표시
			}
		}

	};

	function checkEnemy(){
		for (var i = juckList.length - 1; i >= 0; i--) {
			var tmp =  juckList[i];
			if(tmp.isDead){
				juckList.splice(i,1);
				lifeList.pop();
			}
		}

	};

	var leftEnemy= function(code){
		if(code==37){
			for (var i = 0; i < juckList.length-1; i++) {
				var tmp=juckList[i];
				if (
					tmp.y>400 &&
					tmp.y<650 &&
					tmp.x>50 &&
					tmp.x<150
					) {juckList.splice(i,1);
						score++;
					velocity+=0.2;
				}
			}
	}
};

	var upEnemy= function(code){
		if(code==38){
			for (var i = 0; i < juckList.length-1; i++) {
				var tmp=juckList[i];
				if (
					tmp.y>400 &&
					tmp.y<650 &&
					tmp.x>150 &&
					tmp.x<250
					) {juckList.splice(i,1);
						score++;
					velocity+=0.2;
				}
			}
	}
};

	var downEnemy= function(code){
		if(code==40){
			for (var i = 0; i < juckList.length-1; i++) {
				var tmp=juckList[i];
				if (
					tmp.y>400 &&
					tmp.y<650 &&
					tmp.x>250 &&
					tmp.x<350
					) {juckList.splice(i,1);
						score++;
					velocity+=0.2;
				}
			}
	}
};

	var rightEnemy= function(code){
		if(code==39){
			for (var i = 0; i < juckList.length-1; i++) {
				var tmp=juckList[i];
				if (
					tmp.y>400 &&
					tmp.y<650 &&
					tmp.x>350 &&
					tmp.x<450
					) {juckList.splice(i,1);
						score++;
					velocity+=0.2;
				}
			}
	}
};
		



	var $ = function(sel){
		var result = document.querySelector(sel);
		return result;
	};
	document.querySelectorAll("body")[0]
		.addEventListener("keydown", function(e){
			var code = e.keyCode;
			console.log(code);
			if(code==37){
				console.log("left Arrow");
				leftEnemy(37);
			} else if(code==38){
				console.log("up Arrow");
				upEnemy(38);
			} else if(code==40){
				console.log("right Arrow");
				downEnemy(40);
			} else if(code==39){
				console.log("down Arrow");
				rightEnemy(39);
			}
		});
</script>
	
</body>
</html>