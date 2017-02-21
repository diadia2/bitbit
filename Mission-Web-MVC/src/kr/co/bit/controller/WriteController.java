package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.util.BitFileNamePolicy;

public class WriteController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		// ���ε� �Ϸ��� ���� ��ġ ���� --> �����η� ����
		String saveFolder = "C:/Users/user/workspace/Mission-Web/WebContent/upload";
		
		MultipartRequest multi = new MultipartRequest(request, 
													  saveFolder, 
													  1024 * 1024 * 3, 
													  "utf-8",
													  new BitFileNamePolicy()
													  ); // ���� ���ε� �Ϸ�
		
		// 1. �Խù� ����
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		// BoardVO ��ü ���� �� �ʱ�ȭ
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		// �Խ��� ��ȣ ����
		BoardDAO dao = new BoardDAO();
		int no = dao.selectNo();
		board.setNo(no);
		
		// DB�� ����
		dao.insert(board);
		
		// 2. ÷������ ����(t_board_file)
		Enumeration files = multi.getFileNames();
		while(files.hasMoreElements()){
			String fileName = (String)files.nextElement();
			File f = multi.getFile(fileName);							// --> multi.getFile('attachFile');
			if(f != null){
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				int fileSize = (int)f.length();
				
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setNo(no);
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				
				dao.insertFile(fileVO);			
			}
		}		
		
		return "/board/write.jsp";
	}

}
