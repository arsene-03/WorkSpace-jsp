<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AjaxTest">
	아이디: <input type="text" name="userId" id="userId"> 
	<input type="button" value="중복체크" onclick="idChk()"><br>
	이름: <input type="text" name="userName" id="userName"> <br>
	비밀번호: <input type="password" name="userPwd" id="userPwd"> <br>
	<input type="button" value="JSON 전송" onclick="jsonTransport()"> <br>
	<input type="submit" value="확인">
<script type="text/javascript">

function idChk(){ 
	// 서버로 데이터를 보내기 위해서 알려주어야 할 정보 3가지
	// 1. 서버는 어디있는가? => 서버주소
	// 2. 전송방식은 어떤것을 사용할 것인가 => POST GET
	// 3. 어떤 데이터를 보낼 것인가? => 변수에 담아서

	var req = new XMLHttpRequest();

	var userId = document.getElementById("userId").value;

	req.open("GET","AjaxTest01?userId="+userId);
	req.send(null);
}

function jsonTransport(){
	var req = new XMLHttpRequest();

	var userId= document.getElementById("userId").value;
	var userName= document.getElementById("userName").value;
	var userPwd= document.getElementById("userPwd").value;

	var userData = {
		"userId" : userId,
		"userName" : userName,
		"userPwd" : userPwd
	}

	req.open("GET","AjaxTest02?userData="+JSON.stringify(userData));
	req.send(null);

}


</script>
</form>
</body>
</html>