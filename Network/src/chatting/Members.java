package chatting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Members {
	String id = null;
	String pw = null;
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	final String driver = "oracle.jdbc.driver.OracleDriver";

	public void newMember(String id, String pw) {

		this.id = id;
		this.pw = pw;
		try {
			Class.forName(driver); // ����̹� ����......
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			stat = conn.createStatement();
			rs = stat.executeQuery("insert into members values (\'" + id + "\',\'" + pw + "\')");
			rs = stat.executeQuery("commit");

			System.out.println("ȸ�������� �Ϸ� �Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println("ȸ�� ID�� �����մϴ�.");
		}
	}

	public void Login(String id, String pw) {

		this.id = id;
		this.pw = pw;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from members where chatId = '" + this.id + "'");

			rs.next();
			if (rs.getString(2).equals(this.pw)) {
				System.out.println("������ �����Ͽ����ϴ�.");
				Client c1 = new Client(this.id, this.pw);
				c1.getClient();
			} else{
				System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			}
			
			// rs.close();
			// stat.close();
			// conn.close();

		} catch (Exception e) {
			System.out.println("ID�� �������� �ʽ��ϴ�.");
		}
	}
}