<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	HOME
	<a href="${ pageContext.request.contextPath }/board/list.do">게시판</a>
	<c:if test="${empty userVO }">
		<a href="${ pageContext.request.contextPath }/login/loginForm.do">로그인</a>
	</c:if>
	로그아웃
</body>
</html>