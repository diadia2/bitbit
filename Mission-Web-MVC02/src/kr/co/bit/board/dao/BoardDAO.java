package kr.co.bit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

/**
 * �Խ���(t_board)�� �Է�, �˻�, ����, ��������� �ϴ� ���Ŭ����
 * 
 */
public class BoardDAO {

	/**
	 * ��ü�Խù� ��ȸ ,����¡
	 * 
	 * @return ��ȸ�� ��ü �Խù�
	 */
	public List<BoardVO> selectAllBoard(int page, int rowpage) {

		int start = (page*rowpage)-(rowpage-1);
		int end = (page*rowpage);

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// ��ü �Խù� �����ϴ� BoardVo�迭 ����
		List<BoardVO> list = new ArrayList<BoardVO>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from ");
		sql.append(" (select rownum rnum, no, title, writer, content, view_cnt, reg_date from ");
		sql.append(" (select * from t_board order by no desc)) ");
		sql.append(" where rnum between "+start+" and "+ end);

		try {
			conn = new ConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				int viewCnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");

				// ��ȣ, ����, �ۼ���, �ۼ����� ������ VOŬ���� ��ü
				BoardVO board = new BoardVO();
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setViewCnt(viewCnt);
				board.setRegDate(regDate);

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return list;
	}

	/**
	 * �Խù� ��ȣ�� �ش��ϴ� �Խù��� ��ȸ�ϴ� �޼ҵ�
	 * 
	 * @param no
	 * @return �Խù�VO
	 */

	public BoardVO selectByNo(int no) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardVO board = new BoardVO();

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, content, view_cnt, to_char(reg_date, 'yyyy-mm-dd') reg_date ");
			sql.append(" from t_board ");
			sql.append(" where no = ? ");

			conn = new ConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			rs.next();

			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setViewCnt(rs.getInt("view_cnt"));
			board.setRegDate(rs.getString("reg_date"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return board;
	}

	public void delete(int no) {

		StringBuilder sql = new StringBuilder();
		sql.append("delete t_board where no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setInt(1, no);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public int getViewCnt(int no) {

		int hit = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("select view_cnt from t_board where no = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			hit = rs.getInt("view_cnt");
		} catch (Exception e) {
			e.getMessage();
		}

		return hit;
	}

	public void addViewCnt(int no, int hit) {

		hit = hit + 1;
		StringBuilder sql = new StringBuilder();
		sql.append("update t_board set view_cnt = ? where no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, hit);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void insert(BoardVO board) {

		int loc = 1;

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board(no,title,writer,content) ");
		sql.append(" values (?, ?, ?, ?) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(loc++, board.getNo());
			pstmt.setString(loc++, board.getTitle());
			pstmt.setString(loc++, board.getWriter());
			pstmt.setString(loc++, board.getContent());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.getMessage();
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////   �ӽõ��
	public void insertBoard(BoardVO board) {

		int loc = 1;

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board(no,title,writer,content) ");
		sql.append(" values (seq_t_board_no.nextval, ?, ?, ?) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(loc++, board.getTitle());
			pstmt.setString(loc++, board.getWriter());
			pstmt.setString(loc++, board.getContent());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * �Խ��� ���̺� ������ �Խ��� ��ȣ��, ÷�������� ������ ���̺��� �Խ��� ��ȣ�� ���� ����ϱ� ���� �Խ��� ��ȣ ����
	 */

	public int selectNo() {
		String sql = "select seq_t_board_no.nextval from dual";
		int no = 0;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			no = rs.getInt(1);
		} catch (Exception e) {
			e.getMessage();
		}

		return no;
	}

	/**
	 * ÷������ ���õ� CRUD
	 * 
	 * @param fileVO
	 */

	public void insertFile(BoardFileVO fileVO) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board_file(no, board_no, file_ori_name, file_save_name, file_size) ");
		sql.append(" values (seq_t_board_file_no.nextval, ?, ?, ?, ?) ");

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, fileVO.getNo());
			pstmt.setString(2, fileVO.getFileOriName());
			pstmt.setString(3, fileVO.getFileSaveName());
			pstmt.setInt(4, fileVO.getFileSize());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public List<BoardFileVO> selectFileByNo(int boardNo){
		List<BoardFileVO> fileList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select file_ori_name, file_save_name, file_size ");
		sql.append(" from t_board_file where board_no = ? ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setFileOriName(rs.getString("file_ori_name"));
				fileVO.setFileSaveName(rs.getString("file_save_name"));
				fileVO.setFileSize(rs.getInt("file_size"));
				
				fileList.add(fileVO);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally{
			JDBCClose.close(conn, pstmt);
		}
		return fileList;
	}
	
	/**
	 * �� �Խù� ��
	 */
	
	public int totalBoard(){
		
		int total = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) from t_board ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			)
		{
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			total = rs.getInt(1);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return total;
	}
}