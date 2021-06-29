<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./script/jquery-3.6.0.js"></script>
</head>
<body>
<form action="AjaxTest">
	아이디: <input type="text" name="userId" id="userId"> 
	<input type="button" value="중복체크" onclick="idChk()"><br>
	이름: <input type="text" name="userName" id="userName"> <br>
	비밀번호: <input type="password" name="userPwd" id="userPwd"> <br>
	<input type="button" value="JSON 전송" onclick="jsonTransport()"> <br>
	<input type="submit" value="확인">
	<div id="msg"></div>
</form>

<script>

function idChk(){
	$.ajax({
		type:"GET", //데이터 전송 방식 : GET , POST
		async: true, // 동기화 : false / 비동기 : true
		url:"AjaxTest05", // 서버의 위치
		data:{			// 서버로 보낼 데이터
			userId: $('#userId').val()			
		},
		dataType:"text",	//서버로 부터 받을 데이터의 타입
		success:function(data,textStatus){   //서버와 데이터 교류가 완료되면 실행될 함수
			$('#msg').append(data);
		
		},error:function(){ //서버와 데이터 교류가 실패되면 실행될 함수
			alert('에러가 발생했습니다.');

		},complete:function(){//모든 코드가 완료된 후 실행되는 함수
			alert('작업을 완료했습니다.');
		}

	});

}

</script>

</body>
</html>