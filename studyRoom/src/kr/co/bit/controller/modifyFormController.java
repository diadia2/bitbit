package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

public class modifyFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		// �ش� ��ȣ
		int no = Integer.parseInt(request.getParameter("no"));
		// �Խù� ��ȸ
		BoardVO board = dao.selectByNo(no);
		// ÷������ ��ȸ
		// List<BoardFileVO> fileList = dao.selectFileByNo(no);
		request.setAttribute("board", board);
		// request.setAttribute("fileList", fileList);
		
		return "/board/modifyForm.jsp";
	}
}
