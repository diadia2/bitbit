package kr.co.bit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.bit.board.vo.BoardCommentVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.util.ConnectionFactory;

/**
 * �Խ��� Data Access Object
 * 
 * �Խ��� DB ��ȸ, �߰�, ����, ���� +++�˻� ��ۿ� ���
 * 
 * ��� DB ��ȸ, �߰�, ����, ���� +++��ۿ� ��� �ޱ�
 * 
 * ����¡
 * 
 * +++���� DB ��ȸ, �߰�, ����, ���� ---����!
 * 
 * @author user
 */
public class BoardDAO {
	/**
	 * �Խ��� ��ü ��ȸ
	 * 
	 * @return ArrayList<BoardVO>
	 */
	public ArrayList<BoardVO> selectAllBoard() {
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') reg_date, view_cnt ");
		sql.append("from board ");
		sql.append("where type = 'q' ");
		sql.append("order by GRP_NO desc, GRP_ODER desc");
		
		ArrayList<BoardVO> list = new ArrayList<>();
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getString("reg_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ü �Խù� ��
	 * 
	 * @return int
	 */
	public int totalBoard() {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) ");
		sql.append("from board ");
		sql.append("where type = 'q'");
		int total = 0;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	public ArrayList<BoardVO> selectNoticeBoard() {
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') reg_date, view_cnt ");
		sql.append("from board ");
		sql.append("where type = 'n' ");
		sql.append("order by GRP_NO desc, GRP_ODER desc ");
		ArrayList<BoardVO> list = new ArrayList<>();
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getString("reg_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * �Խ��� ��ȣ ��ȸ
	 * 
	 * @param no
	 * @return BoardVO
	 */
	public BoardVO selectByNo(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, content, view_cnt, to_char(reg_date,'yyyy-mm-dd') reg_date, view_cnt ");
		sql.append("from board ");
		sql.append("where no=? ");
		BoardVO board = null;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			board = new BoardVO();
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content").replace("\r\n", "<br/>"));
			board.setViewCnt(rs.getInt("view_cnt"));
			board.setRegDate(rs.getString("reg_date"));
			board.setViewCnt(rs.getInt("view_cnt"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}/////////////////////////////////////// �۾�����ȸ, ������ȸ/////////////
		/////////////////////////////////////// �߰��ؼ�///////////////////////////////////////////////
		/////////////////////////////////////// �˻����///////////////////////////////////////////////////////////////////////

	/**
	 * �Խ��� �� �߰�
	 * 
	 * @param board
	 */
	public void insertBoard(BoardVO board) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into board(no, title, writer, content, type, GRP_NO) ");
		sql.append("values(SEQ_BOARD_NO.NEXTVAL, ?, ?, ?, ?, SEQ_BOARD_NO.currval)");
		int loc = 1;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(loc++, board.getTitle());
			pstmt.setString(loc++, board.getWriter());
			pstmt.setString(loc++, board.getContent());
			pstmt.setString(loc++, board.getType());
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �Խ��� ��� �߰�
	 * 
	 * @param board
	 */
	public void insertReply(BoardVO board) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into board(no, title, writer, content, type, GRP_NO, GRP_ODER, GRP_DEPTH) ");
		sql.append("values(SEQ_BOARD_NO.NEXTVAL, ?, ?, ?, ?, ");
		sql.append("(SELECT GRP_NO FROM board where no = ?), ");
		sql.append("(SELECT GRP_ODER+1 FROM board where no = ?), ");
		sql.append("(SELECT GRP_DEPTH+1 FROM board where no = ?))");
		int loc = 1;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(loc++, board.getTitle());
			pstmt.setString(loc++, board.getWriter());
			pstmt.setString(loc++, board.getContent());
			pstmt.setString(loc++, board.getType());
			pstmt.setInt(loc++, board.getNo());
			pstmt.setInt(loc++, board.getNo());
			pstmt.setInt(loc++, board.getNo());
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �Խù� ����
	 * 
	 * @param no
	 */
	public void modifyByNo(BoardVO board) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE board SET  ");
		sql.append("title =?, content=? ");
		sql.append("WHERE NO = ?");
		int loc = 1;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(loc++, board.getTitle());
			pstmt.setString(loc++, board.getContent());
			pstmt.setInt(loc++, board.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �Խù� ����
	 * 
	 * @param no
	 */
	public void delete(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM board ");
		sql.append("WHERE no = ? ");
		int loc = 1;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(loc++, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �Խù� ��ȸ�ø��� ī��Ʈ ���ִ� �޼���
	 * 
	 * @param no
	 */
	public void Hit(int no) {
		String sql = "UPDATE board SET  view_cnt = view_cnt+1 WHERE NO = ? ";
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	////////////////////////////////////////////// �Ф��Ϻκ�
	/**
	 * tb_board�� ������ �Խ��� ��ȣ, tb_board_file�� ������ �Խ��� ��ȣ ����
	 * 
	 * @return no
	 */
	public int selectNo() {
		String sql = "select seq_board_no.nextval from dual";
		int no = 0;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			no = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return no;
	}

	/**
	 * ÷������ DB����
	 * 
	 * @param file
	 */
	/*
	 * public void insertFile(BoardFileVO file) { StringBuilder sql = new
	 * StringBuilder(); sql.
	 * append("insert into tb_board_file(no, file_name_ori, file_name_save, file_size, board_no) "
	 * ); sql.append("values(seq_board_file_no.NEXTVAL, ?, ?, ?, ?)"); int loc =
	 * 1; try (Connection conn = new ConnectionFactory().getConnection();
	 * PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
	 * pstmt.setString(loc++, file.getFile_name_ori()); pstmt.setString(loc++,
	 * file.getFile_name_save()); pstmt.setInt(loc++, file.getFileSize());
	 * pstmt.setInt(loc++, file.getBoardNo());
	 * 
	 * pstmt.executeUpdate(); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * DB�� ����� ÷������ ���� ��ȸ
	 * 
	 * @param no
	 * @return fileList
	 */
	/*
	 * public List<BoardFileVO> selectFileByNo(int no) { List<BoardFileVO>
	 * fileList = new ArrayList<>(); StringBuilder sql = new StringBuilder();
	 * sql.append("select FILE_NAME_ORI, FILE_NAME_SAVE, FILE_SIZE ");
	 * sql.append("from TB_BOARD_FILE "); sql.append("where  BOARD_NO = ?"); try
	 * (Connection conn = new ConnectionFactory().getConnection();
	 * PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
	 * pstmt.setInt(1, no); ResultSet rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) { BoardFileVO file = new BoardFileVO();
	 * file.setFile_name_ori(rs.getString("FILE_NAME_ORI"));
	 * file.setFile_name_save(rs.getString("FILE_NAME_SAVE"));
	 * file.setFileSize(rs.getInt("FILE_SIZE")); fileList.add(file); } } catch
	 * (Exception e) { e.printStackTrace(); } return fileList; }
	 */

	/**
	 * ��� DB����
	 * 
	 * @param cmt
	 */
	public void insertCmt(BoardCommentVO cmt) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into board_cmt(no, writer, coment, board_no) ");
		sql.append("values(SEQ_BOARD_CMT_NO.NEXTVAL, ?, ?, ?)");
		int loc = 1;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(loc++, cmt.getWriter());
			pstmt.setString(loc++, cmt.getComent());
			pstmt.setInt(loc++, cmt.getBoardNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * DB�� ����� ��� ��ȸ
	 * 
	 * @param no
	 * @return fileList
	 */

	public ArrayList<BoardCommentVO> selectCmtByNo(int no) {
		ArrayList<BoardCommentVO> cmtList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select writer, coment, to_char(reg_date, 'yyyy-mm-dd') reg_date ");
		sql.append("from BOARD_CMT ");
		sql.append("where  board_no = ? ");
		sql.append("order by no");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardCommentVO cmt = new BoardCommentVO();
				cmt.setWriter(rs.getString("writer"));
				cmt.setComent(rs.getString("coment"));
				cmt.setRegDate(rs.getString("reg_date"));
				cmtList.add(cmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmtList;
	}

	/**
	 * ����¡
	 * 
	 * @param page
	 * @param rowpage
	 * @return
	 */
	public ArrayList<BoardVO> selectAllBoard(int page, int rowpage) {
		int start = (page * rowpage) - (rowpage - 1);
		int end = (page * rowpage);
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from ");
		sql.append(" (select rownum rnum, no, title, writer, to_char(reg_date, 'yyyy-mm-dd') reg_date, view_cnt, GRP_DEPTH from ");
		sql.append("(select * from board where type = 'q' order by GRP_NO desc, GRP_ODER)) ");
		sql.append("where rnum between " + start + " and " + end);
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getString("reg_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setDepth(rs.getInt("GRP_DEPTH"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
