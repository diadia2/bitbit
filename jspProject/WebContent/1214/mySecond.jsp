<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<h1>Declaration Example</h1>
>
<body>
	<!-- String�� null, int�� 0���� �ڵ� �ʱ�ȭ -->
	<%!int one;
	int two = 1;

	public int plusMethod() {
		return one + two;
	}

	String msg;
	int three;
	String resourcePath = "back";%>
	one�� two�� ����?<%=plusMethod()%><p>
		String msg�� ����?<%=msg%>
	<p>
		int three�� ����?<%=three%>
		<%=application.getRealPath(resourcePath)%>
		<%
			for (int i = 0; i <= 10; i++)
				out.println("Hello World" + i + "</br>");
		%>
	
</body>
</html>