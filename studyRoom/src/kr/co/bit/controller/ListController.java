package kr.co.bit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

public class ListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> noticelist = dao.selectNoticeBoard();
		request.setAttribute("noticelist", noticelist);
		//����¡
		String pgstr = request.getParameter("pg");
		if (pgstr == null) {
			pgstr = "1";
		}
		int pg = Integer.parseInt(pgstr);
		int block = 5;
		int rowpage = 10;
		int total = dao.totalBoard();/////
		int allpage = total / rowpage + (total % rowpage != 0 ? 1 : 0);
		int startpage = ((pg - 1) / block * block) + 1;
		int endpage = 0;
		if ((total / rowpage) + (total % rowpage != 0 ? 1 : 0) < ((pg - 1) / block * block) + block) {
			endpage = (total / rowpage) + (total % rowpage != 0 ? 1 : 0);
		} else {
			endpage = ((pg - 1) / block * block) + block;
		}

		ArrayList<BoardVO> list = dao.selectAllBoard(pg, rowpage);
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("block", block);
		request.setAttribute("allpage", allpage);
		return "/board/list.jsp";
	}

}