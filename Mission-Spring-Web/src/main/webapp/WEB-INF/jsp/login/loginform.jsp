<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/layout.css" />

<script type="text/javascript">
	function doAction() {
		location.href = "${pageContext.request.contextPath}/member/newmemberform.do";
	}

	function isNull(obj, msg) {
		if (obj.value == "") {
			alert(msg);
			obj.focus();
			return true;
		}
		return false;
	}

	function memberCheck() {
		var form = document.inputForm;

		if (isNull(form.id, "아이디를 입력하세요"))
			return false;

		if (isNull(form.pw, "비밀번호를 입력하세요"))
			return false;

		return true;
	}
</script>
</head>
<body>

	<header>
		<c:import url="/include/topMenu.do" />
	</header>
	<section>
	<div align="center">
		<h2 style="background-color: lightblue">로그인 화면</h2>
		<hr width="80%" />
		<br />
		<form name="inputForm"
			action="${ pageContext.request.contextPath }/login/login.do"
			method="post" onsubmit="return memberCheck()">
			<table width="50%">
				<tr>
					<th width="50%">아이디</th>
					<td><input type="text" name="id" size="30"
						value="${ cookie.loginId.value }"></td>
				</tr>
				<tr>
					<th width="50%">비밀번호</th>
					<td><input type="password" name="password" size="30"></td>
				</tr>
				</table>
				<div align="center">
				<input type="checkbox" name="idSave" value="y"
						<c:if test="${ not empty cookie.loginId }"> checked="checked"/ </c:if> />
						<label>아이디 저장</label>
				</div>
			<br /> <input type="submit" value=" 로그인 " />&nbsp; 
			<input type="button" value=" 회원가입 " onclick="doAction()" />
		</form>
	</div>
	</section>
	<footer>
		<c:import url="/include/footer.do" />
	</footer>

</body>
</html>
