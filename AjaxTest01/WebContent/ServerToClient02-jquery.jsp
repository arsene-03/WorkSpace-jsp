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
            url:"AjaxTest08",
            datatype:"XML",
            success:function(data,textStatus){
                $(data).find("book").each(function(){
                    var title = $(this).find("title").text();
                    var writer = $(this).find("writer").text();

                    $("#msg").append(
                        "<p> 책 제목 : "+title+"</p>"+
                        "<p> 저   자 : "+writer+"</p><br>"
                    );
                });
            },error:function(){
                alert('에러가 발생했습니다.');
            }
        });
    }

</script>
</body>
</html>