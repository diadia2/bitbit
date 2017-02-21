package kr.co.bit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.service.BoardService;
import kr.co.bit.login.dao.LoginDAO;
import kr.co.bit.login.service.LoginService;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 		// ������ ���� �ɶ� ��¡ �������� ȣ��
        System.out.println("������ ����");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 	// ������ �����Ҷ� ���� ���� ȣ��

         ServletContext sc = event.getServletContext();
         
         BoardDAO boardDao = new BoardDAO();         
         BoardService boardService = new BoardService(boardDao);
         sc.setAttribute("boardService", boardService);
         
         LoginDAO loginDao = new LoginDAO();
         LoginService loginService = new LoginService(loginDao);
         sc.setAttribute("loginService", loginService);
    }
	
}
