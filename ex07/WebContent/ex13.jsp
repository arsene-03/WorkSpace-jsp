<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] movieList = {"소스코드","닥터스트레인지","조커","클래식","노인을 위한 나라는 없다","양들의침묵"};
	pageContext.setAttribute("movieList", movieList);
%>
	<c:forEach var="movieTitle" items="${movieList}">
		${movieTitle} <br>
	</c:forEach>

	<hr>
	<table border="1">
		<tr>
			<td>Index</td>
			<td>Count</td>
			<td>Title</td>
		</tr>
		<c:forEach var="movieTitle" items="${movieList}" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${status.count}</td>
				<td>${movieTitle}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	
	<ul>
		<c:forEach var="movieTitle" items="${movieList}" varStatus="status">
			<c:choose>
				<c:when test="${status.first}">
					<li style="font-weight: bold; color: red;">${movieTitle}</li>
				</c:when>
				<c:when test="${status.last}">
					<li style="background-color:blue; color: white;">${movieTitle}</li>
				</c:when>
				<c:otherwise>
					<li>${movieTitle}</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	<hr>
	<c:forEach var="movieTitle" items="${movieList}" varStatus="status">
		${movieTitle}<c:if test="${not status.last}">,</c:if>
	</c:forEach>
	
	<hr>
	<table border="1">
		<tr>
			<td>index</td>
			<td>count</td>
			<td>숫자</td>
		</tr>
		<c:forEach var="cnt" begin="1" end="5" varStatus="status">
			<tr>
			<td>${status.index }</td>
			<td>${status.count }</td>
			<td>${cnt }</td>
			</tr>
		</c:forEach>
	</table>


	<hr>
	<table border="1">
		<tr>
			<td>index</td>
			<td>count</td>
			<td>숫자</td>
		</tr>
		<c:forEach var="cnt" begin="7" end="10" varStatus="status">
			<tr>
			<td>${status.index }</td>
			<td>${status.count }</td>
			<td>${cnt }</td>
			</tr>
		</c:forEach>
	</table>
	
		<hr>
	<table border="1">
		<tr>
			<td>index</td>
			<td>count</td>
			<td>숫자</td>
		</tr>
		<c:forEach var="cnt" begin="5" end="15" step="3" varStatus="status">
			<tr>
			<td>${status.index }</td>
			<td>${status.count }</td>
			<td>${cnt }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>