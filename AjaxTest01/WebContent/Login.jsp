<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="LS" method="POST" name="frm">
    	
		아이디 : <input type="text" name="userId" id="userId">
        <input type="button" value="중복확인" onclick="idChk()"><br>
        <input type="hidden" name="reid" id="reid">
		이름: <input type="text" name="userName" id="userName"><br>
		비밀번호 : <input type="password" name="userPwd" id="userPwd"><br>
        <input type="submit" value="회원가입" onclick="goo()">
    </form>
<script>
    function idChk(){
        var req = new XMLHttpRequest();
        var userId = document.getElementById("userId").value;
        var reid = document.getElementById("reid").value;

        req.open("GET","LS?userId="+userId);
        req.send(userId);

        req.onreadystatechange = function(){
        	if((req.readyState==4)&&(req.status==200)){
            	alert(req.responseText);
            	reid=req.responseText;
        	}
    	};
    }
    
    function goo() {
		
    if(document.frm.reid.value.length == 0){
		alert('중복 체크를 하지 않았거나, 중복된 아이디 사용중입니다.');
		frm.userId.focus();
		return false;
	}
	return true;
	}
</script>
</body>
</html>