import java.io.*;

//============================================================================
// FileOutputStream
//============================================================================



public class IO2 {
	
	public static void main(String[] args)
	{
		try 
		{
			byte [] bytes = new byte[]{65,65,65,65,65};	// --> �ƽ�Ű �ڵ�� �Էµ�
			
			OutputStream os = new FileOutputStream("bit.txt"); 
			// 1byte�� ���Ͽ� ���� !!
			/*
			for (byte b : bytes)
			{
				os.write(b);
			}
			*/
			//byte �迭�� �ѹ��� ����
			os.write(bytes);
			
			os.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

}
