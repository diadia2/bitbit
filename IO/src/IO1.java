import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// IO
//============================================================================
// Input Output --> ����� !!
//	--> ȭ�� ����� !! --> out.println	Scanner
//	--> �ϵ��ũ, ��Ʈ��ũ, ������, ����Ŀ
//============================================================================
// ��Ʈ�� (stream)
//	--> ����Ÿ�� �帧, ����Ÿ�� �̵��ϱ� ���� ���
//	--> �Է½�Ʈ�� (Input Stream)
//	--> ��½�Ʈ�� (Output Stream)
//============================================================================
//			 InputStream 	// ��� �Է� ��Ʈ���� �θ�Ŭ����
//				read : ��Ʈ���� ���� ����Ÿ�� �о���� �޼ҵ� !!
//				close : ��Ʈ���� ������ ��� !!
//			 /			\
//	FileInputStream  GDIInputStream
//============================================================================
//			OutputStream
//				write : ��Ʈ���� ����Ÿ�� ���� !!
//				close : ��Ʈ���� ������ ��� !!
//		   /
//	FileOutputStream : ���Ͽ� ���� �۾� Ŭ���� !!



public class IO1 {

	public static void main(String[] args)
	{
		// �⺻���� ���� �б� !!
		
		try
		{
			InputStream input = new FileInputStream("C:\\AAA.txt");
			
			while(true)
			{
				char b =(char) input.read();
				if(b==-1)
					break;
				System.out.print((char)b);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}

}








