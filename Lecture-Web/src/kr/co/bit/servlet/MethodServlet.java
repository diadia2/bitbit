package kr.co.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MethodServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//	System.out.println("doGet()�޼ҵ� ȣ��...");
		
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		String method = request.getMethod();
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		
		
		PrintWriter pw = response.getWriter();
		pw.println("<HTML>");
		pw.println("<HEAD><TITLE>��°��</TITLE></HEAD>");
		pw.println("<BODY>");
		pw.println("================================================<br/>");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;��°��<br/>");
		pw.println("================================================<br/>");
		pw.println("�Ķ����(id) : " + id + "<br/>");
		pw.println("�޼ҵ� : " + method + "<br/>");
		pw.println("��ûURL : " + url + "<br/>");
		pw.println("��ûURI : " + uri + "<br/>");
		pw.println("================================================<br/>");
		pw.println("</BODY>");
		pw.println("</HTML>");
		
		pw.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.setCharacterEncoding("utf-8");
		
			String id = request.getParameter("id");
			System.out.println("id : " + id);
			String method = request.getMethod();
			StringBuffer url = request.getRequestURL();
			String uri = request.getRequestURI();
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<HTML>");
			pw.println("<HEAD><TITLE>��°��</TITLE></HEAD>");
			pw.println("<BODY>");
			pw.println("================================================<br/>");
			pw.println("&nbsp;&nbsp;&nbsp;&nbsp;��°��<br/>");
			pw.println("================================================<br/>");
			pw.println("�Ķ����(id) : " + id + "<br/>");
			pw.println("�޼ҵ� : " + method + "<br/>");
			pw.println("��ûURL : " + url + "<br/>");
			pw.println("��ûURI : " + uri + "<br/>");
			pw.println("================================================<br/>");
			pw.println("</BODY>");
			pw.println("</HTML>");
			
			pw.close();
		}

	

	
	
}
