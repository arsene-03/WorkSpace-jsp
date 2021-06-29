<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AjaxTest02">
	아이디: <input type="text" name="userId" id="userId"> 
	<input type="button" value="중복체크" onclick="idChk()"><br>
	이름: <input type="text" name="userName" id="userName"> <br>
	비밀번호: <input type="password" name="userPwd" id="userPwd"> <br>
	<input type="button" value="JSON 전송" onclick="jsonTransport()"> <br>
	<input type="submit" value="확인">

</form>
<script type="text/javascript">

function idChk(){

	var req = new XMLHttpRequest();

	var userId = document.getElementById("userId").value;

	req.open("POST","AjaxTest01");
	req.setRequestHeader("context-type","application/x-www-form-urlencoded")
	req.send(userId);
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
	};

	req.open("POST","AjaxTest02");
	req.setRequestHeader("context-type","application/x-www-form-urlencoded")
	req.send(JSON.stringify(userData));

}




</script>
</body>
</html>