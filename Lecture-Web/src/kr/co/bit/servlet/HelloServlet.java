package kr.co.bit.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class HelloServlet extends HttpServlet{
	
	
	public void init(ServletConfig config) throws ServletException{
		System.out.println("�ѹ��� ����Ǵ� �޼ҵ� �Դϴ�.");
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException{
		System.out.println("���� �۾��� ����Ǵ� �޼ҵ� �Դϴ�.");
		System.out.println("����� ��û�� ó���ϴ� �޼ҵ� �Դϴ�.");
	}
}
