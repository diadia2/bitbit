import java.io.*;

// �⺻ Ÿ���� ����� (int, double)
//	--> ���� ��Ʈ���� �̿� !!
//	--> 


public class IO3 {

	public static void main(String[] args) throws IOException {
		
		
		int data = 4885;
		OutputStream os = new FileOutputStream("IO3.lop");
		// 4����Ʈ, 8����Ʈ�� Ÿ���� ���� !!
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeInt(data);
		dos.close();
		
		//=============================================================
		// ��� : ���Ͽ� ����� ����Ÿ�� �о �����ֱ� !!
		//=============================================================
		InputStream is = new FileInputStream("IO3.lop");
		DataInputStream dis = new DataInputStream(is);
		data = 0;
		data = dis.readInt();
		
		System.out.print("read : " + data);
		
		
		
	}

}
