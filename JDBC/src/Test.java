import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet jobs = null;
		
		try {
			// ����Ŭ ����̹��� �ε��Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ����Ÿ ���̽��� ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
			// Statement object�� ����
			stmt = conn.createStatement();
			// ResultSet�� ������� SQL query�� ����
// �߰�		stmt.executeUpdate("insert into student values(\'ȫ����\',\'������\',\'5555555\')");
// ����		stmt.executeUpdate("update student set id=\'4444444\' where name=\'��ָ�\'");
// ����		stmt.executeUpdate("delete from student where name=\'ȫ����\'");
			
			rs = stmt.executeQuery("select * from student"); // table�̸�
			int count = 0;
//			while(rs.next()){
//				System.out.print(++count);
//				System.out.print(" "+rs.getString(1));
//				System.out.print(" "+rs.getString(2));
//				System.out.print(" "+rs.getString(3));
//				System.out.println();
//			}	
			jobs = stmt.executeQuery("select * from jobs");
			while(jobs.next()){
				System.out.print("ID="+jobs.getString(1));
				System.out.print("\tTiTle="+jobs.getString(2));
				System.out.print("\tMinSal="+jobs.getInt(3));
				System.out.print("\tMaxSal="+jobs.getInt(4));
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε忡��");
		}
		catch (SQLException e) {
			e.printStackTrace(); // DB �������
		}
		
		
		
	}

}
