package kr.co.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PInfoResult extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String sex = request.getParameter("sex");
		String[] mail = request.getParameterValues("mail");
		String job = request.getParameter("job");
		
		String str = "��������";
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println(mail.length);
		out.println("<HTML>");
		out.println("<HEAD><TITLE></TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1>���� ���� ���</h1>");
		out.println("�̸� : "+name+"<br/>");
		out.println("���̵� : "+id+"<br/>");
		out.println("��ȣ : "+pw+"<br/>");
		out.println("���� : "+sex+"<br/>");
		for(int i=0; i<mail.length; i++){
			if(mail[i].equals("��������")){
				str = "����";
			}
		}
		out.println("�������� : "+str+"<br/>");
		str="��������";
		for(int i=0; i<mail.length; i++){
			if(mail[i].equals("�������")){
				str = "����";
			}
		}
		out.println("������� : "+str+"<br/>");
		str="��������";
		for(int i=0; i<mail.length; i++){
			if(mail[i].equals("���Ȯ�θ���")){
				str = "����";
			}
		}
		out.println("��� Ȯ�� ���� : "+str+"<br/>");
		out.println("���� : "+job+"<br/>");
		out.println("</BODY>");
		out.println("</HTML>");
		
		out.close();
	}

	
}
