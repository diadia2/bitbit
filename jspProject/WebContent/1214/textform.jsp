<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("EUC-KR");
		String ID = request.getParameter("ID");
		String PW = request.getParameter("Password");
		String intro = request.getParameter("introduce");
	%>
	<b>�Է��� ���� �Դϴ�. ID : <%=ID%></b><p>
	<b>Password : <%=PW%></b><p>
	<b>�ڱ�Ұ� : <%=intro%></b>

</body>
</html>