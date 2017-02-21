package kr.co.bit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.member.dao.BoardDao;
import kr.co.bit.member.vo.BoardVO;

public class LoginController implements Controller{

   @Override
   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      request.setCharacterEncoding("utf-8");
      
      HttpSession session = request.getSession();
      String id=request.getParameter("id");
      String password=request.getParameter("password");
      
      BoardDao dao=new BoardDao();
      BoardVO vo = dao.login(id, password);
      
      String msg = "";
      String url = "";
      if(vo == null){
         msg = "���̵� �Ǵ� �н����尡 �߸� �ԷµǾ����ϴ�.";
         url = request.getContextPath()+"/loginForm.do";
      } else{
         if(vo.getType().equals("a")){
            msg = "�����ڴ� ȯ���մϴ�.";
         } else{
            msg = vo.getName()+"�� ȯ���մϴ�.";   
         }
         url = request.getContextPath()+"/main.do";
      
         session.setAttribute("id", vo.getId());
         session.setAttribute("type", vo.getType());
         session.setAttribute("name", vo.getName());
      }
      request.setAttribute("msg", msg);
      request.setAttribute("url", url);
      
      return "/join/login.jsp";
   }

}