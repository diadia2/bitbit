<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="Bean.MemberInfo" scope="request"/>
<%
	member.setId("conan");
	member.setName("코난");
	member.setPassword("1234");
	member.setEmail("conan@aaa.com");
	member.setRegisterDate(new Date());
%>
<jsp:forward page="UseBean.jsp"/>
</body>
</html>