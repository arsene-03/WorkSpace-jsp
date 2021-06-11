<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean class="com.green.Practice.Product" id="product" scope="session">
	<jsp:setProperty name= "product" property="*"/>
</jsp:useBean>
<%=session.getAttribute("product")%>

	
<script >
var eachBoard = {
        name : "<%=product.getProName()%>",
        
    }
	localStorage.setItem('boardInfo',JSON.stringify(eachBoard));
	alert('게시물 등록완료');
</script>

</body>
</html>