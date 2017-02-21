package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.login.dao.LoginDAO;
import kr.co.bit.login.vo.LoginVO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(id);
		loginVO.setPw(pw);
	
		LoginDAO dao = new LoginDAO();
		LoginVO userVO = dao.login(loginVO);
		
		String msg = "";
		String url = "";
		if(userVO == null){
			msg = "���̵� �Ǵ� �н����尡 �߸� �ԷµǾ����ϴ�.";
			url = request.getContextPath()+"/loginform.do";
		} else{
			if(userVO.getType().equals("S")){
				msg = "�����ڴ� ȯ���մϴ�.";
			} else{
				msg = userVO.getId()+"�� ȯ���մϴ�.";	
			}
			url = request.getContextPath();
			//���� ������ ���
			session.setAttribute("userVO", userVO);
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/member/login.jsp";
	}

}
