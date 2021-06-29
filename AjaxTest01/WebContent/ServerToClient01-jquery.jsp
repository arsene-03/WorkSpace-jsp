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
	<input type="button" value="데이터 가져오기" onclick="inputData()">
    <div id="msg"></div>

    <script>

        function inputData(){

            $.ajax({
                type:"POST",
                async:true,
                url:"AjaxTest07",
                datatype:"JSON",
                success:function(data,textStatus){
                    var userData = JSON.parse(data);
                    $('#msg').append("아이디 : "+userData.userId+"<br>");
                    $('#msg').append("이름 : "+userData.userName+"<br>");
                    $('#msg').append("암호 : "+userData.userPwd+"<br>");

                    // console.log("아이디 : "+userData.userId);
                    // console.log("이름 : "+userData.userName)
                    // console.log("암호 : "+userData.userPwd)

                },error:function(){
                    alert("에러가 발생했습니다.")
                }

            });
        }

    </script>
</body>
</html>