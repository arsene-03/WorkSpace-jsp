<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>숫자 표기</h3>
<fmt:formatNumber value="1234567.89" var="number"/> <!-- 1,234,567.89 -->
<fmt:formatNumber value="1234567.89" groupingUsed="false"/> <!-- 1234567.89 --> <br>

<fmt:formatNumber value="3.5" type="percent"/> <!-- 35% --><br>

<fmt:formatNumber value="50000" type="currency"/> <!--  w50,000 --> <br>
<fmt:formatNumber value="50000" type="currency" currencySymbol="£"/> <!--  £50,000 -->
 
<hr>

<fmt:formatNumber value="1234567.8912345678" pattern="#,#00.0#"/> <br> <!-- 1,234,567.89 -->
<fmt:formatNumber value="1234567.8" pattern="#,#00.0#"/> <br> <!-- 1,234,567.8 -->
<fmt:formatNumber value="1234567.8" pattern="#,#00.000"/> <br> <!-- 1,234,567.800 -->
<fmt:formatNumber value="12.3" pattern="000,000.000"/> <br> <!-- 000,012.300 -->

<hr>

</body>
</html>