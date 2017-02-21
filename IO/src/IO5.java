//	1) C://dog.jpg --> D://dog.jpg : ���� �̵� ���� FileInputStream, FileOutputStream
//	2) --> �޴� �߰� : �ҷ�����, ����
//		BufferedReader	BufferedWriter
//	3) AddrBook �ּҷ� --> ArrayList ����� ��ü : ����, �ҷ����� !!

import java.io.*;
import java.util.Scanner;

//========================================================================
// ���ڿ� ���� ����� !!
//========================================================================
// BufferedReader
// BufferedWriter
//========================================================================

public class IO5 {

	public static void main(String[] args) throws IOException {
		// ����ڰ� x�� �Է��Ҷ����� ���ڿ��� �Է¹޾Ƽ� ���Ͽ� ���� !!
		/*
		BufferedWriter out = new BufferedWriter(new FileWriter("IO5.txt"));
			
		String msg = "";
		Scanner scan = new Scanner(System.in);
		while(!msg.equals("x"))
		{
			System.out.println("input : ");
			msg = scan.nextLine();
			out.write(msg);
			out.newLine();	// ���� ����
		}
		out.close();
		*/
		
		BufferedReader in = new BufferedReader(new FileReader("IO5.txt"));
		
		String msg;
		
		while(true)
		{
			msg = in.readLine();
			if(msg == null)
				break;
			System.out.println(msg);
		}
	}

}
