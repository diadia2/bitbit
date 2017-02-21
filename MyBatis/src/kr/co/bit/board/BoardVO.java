package kr.co.bit.board;

public class BoardVO {
	
	private int no;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int[] nos;
	
	public int[] getNos() {
		return nos;
	}

	public void setNos(int[] nos) {
		this.nos = nos;
	}

	public BoardVO(){
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate+ "]";
	}
	
}