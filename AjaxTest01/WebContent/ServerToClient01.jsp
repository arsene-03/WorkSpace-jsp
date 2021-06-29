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
    
    req.onreadystatechange = function(){
        if((req.readyState==4)&&(req.status==200)){
            document.getElementById("msg").innerHTML = req.responseText;
        }
    };

    req.open("GET","AjaxTest03");
    req.send(null);
}

</script>
</body>
</html>