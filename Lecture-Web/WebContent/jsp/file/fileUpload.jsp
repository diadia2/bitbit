<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드 테스트</h2>
	<form method = "post" action = "uploadInfo.jsp" enctype = "multipart/form-data">
		ID : <input type = "text" name = "id"/><br/>
		파일 : <input type = "file" name = "uploadfile"/><br/>
		<input type = "submit" value = "전송"/>
	</form>
</body>
</html>