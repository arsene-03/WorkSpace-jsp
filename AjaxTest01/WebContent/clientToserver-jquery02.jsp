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
    <form action="AjaxTest06">
        아이디: <input type="text" name="userId" id="userId"> 
        <input type="button" value="중복체크" onclick="idChk()"><br>
        이름: <input type="text" name="userName" id="userName"> <br>
        비밀번호: <input type="password" name="userPwd" id="userPwd"> <br>
        <input type="button" value="JSON 전송" onclick="jsonTransport()"> <br>
        <input type="submit" value="확인">
        <div id="msg"></div>
    </form>
    <script>
        function jsonTransport(){
            var userId = $('#userId').val();
            var userName = $('#userName').val();
            var userPwd = $('#userPwd').val();
        }

        var userData = {
            "userId":userId,
            "userName":userName,
            "userPwd":userPwd
        };

        $.ajax({
            type:"POST",
            async:true,
            url:"AjaxTest06",
            data:{
                "userData":JSON.stringify(userData)
            },
            error:function(){
                alert('에러가 발생했습니다.')
            }
        });
        
    </script>
</body>
</html>