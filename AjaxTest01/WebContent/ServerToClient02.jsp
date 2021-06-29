<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="값 읽어오기" onclick="readData()">
    <div id="msg"></div>
<script>

function readData(){
    var req = new XMLHttpRequest();
    req.open("GET","AjaxTest04");
    req.send(null);

    // req.onreadystatechange = function(){
    //         if((req.readyState==4)&&(req.status==200)){
    //             document.getElementById("msg").innerHTML = req.responseText;
    //         }
    //     };
    // }
        req.onreadystatechange = function(){
                if((req.readyState==4)&&(req.status==200)){
                    var data = JSON.parse(req.responseText);

                    var userId = data.userId;
                    var userName = data.userName;
                    var userPwd = data.userPwd;

                    var msg = document.getElementById("msg");

                    msg.innerHTML = "userId: "+userId + "<br>" + "userName: "+userName + "<br>" + "userPwd: "+userPwd + "<br>"
                }
            };
        }

</script>
</body>
</html>