package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

public class DetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();
		// �ش� ��ȣ
		int no = Integer.parseInt(request.getParameter("no"));
		int sno;
		// ��ȸ��UP
		HttpSession session = request.getSession();
		if (session.getAttribute("no") != null) {
			sno = (int) session.getAttribute("no");
			if (no != sno)
				dao.Hit(no);
		}else
			dao.Hit(no);
		session.setAttribute("no", no);
		// �Խù� ��ȸ
		BoardVO board = dao.selectByNo(no);
		// ÷������ ��ȸ
		// List<BoardFileVO> fileList = dao.selectFileByNo(no);
		request.setAttribute("board", board);
		// request.setAttribute("fileList", fileList);
		return "/board/detail.jsp";
	}

}
