import java.io.*;

//=======================================================================
// text���� ���Ͽ� ���� !!
//=======================================================================
// --> FileReader : �ؽ�Ʈ ������ �б� �޼ҵ� !!
// --> FileWriter : �ؽ�Ʈ ������ ���� �޼ҵ� !!
//=======================================================================


public class IO4 {

	public static void main(String[] args) {

		char ch1 = 'A';
		char ch2 = 65;
		
		try 
		{
			//����
	//		Writer out = new FileWriter("IO4.txt");
	//		out.write(ch1);
	//		out.write(ch2);
	//		out.close();
			// �б�
			char [] buf = new char[10];
			Reader reader = new FileReader("IO4.txt");
			
			/*
			int c;		
			while((c = reader.read()) != -1)
				System.out.println(c);
			*/
			// ���Ͽ��� ���� ����Ʈ �� !!
			while(true)
			{int readCnt = reader.read(buf, 0, buf.length);
				
			if(readCnt==-1)
				break;
				for(int i = 0; i<readCnt; i++)
			{
				System.out.print(buf[i]);
			}
			}
			
			reader.close();
			
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

}
