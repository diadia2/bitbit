package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
	/* default void info(){}; //1.7���� default�� ��밡��, ���߿�x, ���������� */
}
