<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.green.beans.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>



<%--1. 자바빈 객체생성 --%>
<%
//방법 1. 스크립트릿에서 자바빈 생성
Member member1 = new Member();
session.setAttribute("member1", member1);
// 방법2. 액션태그로 자바빈 생성
%>
<jsp:useBean class="com.green.beans.Member" id="member2" scope="session"/>


<%--2. 자바빈 객체생성 --%>
<%
//방법 1.
//String name = request.getParameter("name");
//String userId = request.getParameter("userId");
//String nickName = request.getParameter("nickName");
//String userPwd = request.getParameter("userPwd");
//String email = request.getParameter("email");
//String phone = request.getParameter("phone");

//member1.setName(name);
//member1.setUserId(userId);
//member1.setNickName(nickName);
//member1.setUserPwd(userPwd);
//member1.setEmail(email);
//member1.setPhone(phone);

//방법 2. (=방법1)
member1.setName(request.getParameter("name"));
member1.setUserId(request.getParameter("userId"));
member1.setNickName(request.getParameter("nickName"));
member1.setUserPwd(request.getParameter("userPwd"));
member1.setEmail(request.getParameter("email"));
member1.setPhone(request.getParameter("phone"));


%>
<%--방법3 (액션태그) --%>
<%--
<jsp:setProperty name= "member2" property="name" value="<%=request.getParameter("name") %>"/>
<jsp:setProperty name= "member2" property="userId" value="<%=request.getParameter("userId") %>"/>
<jsp:setProperty name= "member2" property="nickName" value="<%=request.getParameter("nickName") %>"/>
<jsp:setProperty name= "member2" property="userPwd" value="<%=request.getParameter("userPwd") %>"/>
<jsp:setProperty name= "member2" property="email" value="<%=request.getParameter("email") %>"/>
<jsp:setProperty name= "member2" property="phone" value="<%=request.getParameter("phone") %>"/>
 --%>


<%--방법4 (액션태그) --%>
<%--
<jsp:setProperty name= "member2" property="name" />
<jsp:setProperty name= "member2" property="userId" />
<jsp:setProperty name= "member2" property="nickName"/>
<jsp:setProperty name= "member2" property="userPwd"/>
<jsp:setProperty name= "member2" property="email"/>
<jsp:setProperty name= "member2" property="phone"/>
 --%>
 
<%--방법5(액션태그) --%>
<jsp:setProperty name= "member2" property="*"/>

<%-- 3. 입력된 회원 정보 출력 --%>
<h2>입력된 회원 정보 출력</h2>
<%--방법 1 --%>
이름: <%=member1.getName() %> <br>
닉네임: <%=member1.getNickName() %> <br>
아이디: <%=member1.getUserId() %> <br>
비밀번호: <%=member1.getUserPwd() %> <br>
이메일: <%=member1.getEmail() %> <br>
전화번호: <%=member1.getPhone() %> <br>

<hr>
<%--방법2(액션태그) --%>
이름: <jsp:getProperty property="name" name="member2"/>
닉네임: <jsp:getProperty property="userId" name="member2"/>
아이디: <jsp:getProperty property="nickName" name="member2"/>
비밀번호: <jsp:getProperty property="userPwd" name="member2"/>
이메일: <jsp:getProperty property="email" name="member2"/>
전화번호: <jsp:getProperty property="phone" name="member2"/>




</body>
</html>