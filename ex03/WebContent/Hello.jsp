<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP!!</h1>
	<%!
		public void a1(){
			System.out.println("에러");
		}
		int jumsu =100;
		public String str(){
			return "반갑";
		}
	%>
	<%
	int num1 = 10;
	int num2 = 20;
	
	int add = num1+num2;
	
	//out.println("합계: "+add);  // 이미 기술되어 있음		
		
	%>
	<!-- html 주석 : 웹 브라우저가 판단 => 클라이언트가 볼 수있음-->
	<%-- 주석으로 동작 : WAS해석 => 클라이언트가 볼 수 없음--%>
	<%=num1 %> <%--out.println(num1); --%> <br>
	<%=num1 %>+<%=num2 %>=<%=add %> <%--out.println(num1+"+"+num2+"="+add);와 같음 --%><br>
	<%=str() %>
</body>
</html>