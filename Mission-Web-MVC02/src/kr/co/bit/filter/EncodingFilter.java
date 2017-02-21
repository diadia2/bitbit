package kr.co.bit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


public class EncodingFilter implements Filter {		// ��û, ���� ������ ���͸� �ϳ� ���� �߰����� ���� �� ���� ����

	private FilterConfig config;
	@Override
	public void destroy() {
		System.out.println("Filter �Ҹ�...");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter �۾�����...");
		
		request.setCharacterEncoding(config.getInitParameter("utf-8"));
		chain.doFilter(request, response);
		System.out.println("Filter ����...");

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Filter �ʱ�ȭ...");
		this.config = config;
	}

}
