<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> <%-- ������ --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JSP ��ũ��Ʈ Example</title>
</head>
<body>
<h1>Script Example</h1>
<%! String declaration = "Declaration"; %>
<%! public String decMethod(){
		return declaration;
		}%>
<% String scriptlet = "Scriptlet";
	String comment = "Comment"; 
	out.println("���尴ü�� �̿��� ��� : " + declaration + "<p>");%>
	
������ ��� 1 : <%=declaration %><p>
������ ��� 2 : <%=decMethod() %><p>
��ũ��Ʈ���� ��� : <%=scriptlet %><p>
<!-- JSP�ּ��κ� -->
<!-- JSP �ּ�1 : <%=comment%> --><p>
<%-- JSP �ּ�2 : <%=comment%> --%><p>
<% /* �ּ�
(������ �ּ�)
*/%>
<%//�����ּ� %>		
</body>
</html>