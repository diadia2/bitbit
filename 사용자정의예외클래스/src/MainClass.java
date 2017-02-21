import java.util.Scanner;
//=======================================================================
// �ֹι�ȣ �Է� ���� Ŭ������ �ۼ��ض� !!
// �ֹι�ȣ : 13�ڸ� �Է¹޾Ƽ� ��ȿ���� ���� �ֹι�ȣ�̸� ���� ���� !!
// ex) 770101-1100123
//	--> 3��° �ڸ��� 2�̻� ���ü� ����
//	--> 5~6��° �ڸ��� 31���� ���;� �� ���
//=======================================================================
// 1-100 ������ ������ �߻�
// ����� ������ 1-45���̿� �ִ� ���� "�߻��� �ζ� ��ȣ�� XX�Դϴ�."
// ����� ������ 46-100 ���̿� �ִ� ���� ����(LottoNumverException)�� �߻����� ó���ϴ� ���α׷� �ۼ�
//=======================================================================
// ������ ���� �迭�� ���� !!
// int size = scan.nextInt();
// int [] array = new int[size]; / size�� ������ ����� ���� �߻� !!
// 1) �迭�� ����ڷκ��� �Է� �޾Ƽ� �ʱ�ȭ (0�� �ԷµǸ�) : ZeroInputException
// 2) �迭�� ��ü ��� !! : ArrayIndexOutofBoundsException !!
// 3) finally : ���� �޽��� ���
//=======================================================================
// ���� Ŭ������ ������ !!
//=======================================================================
/* 					Throwable
 						|
 					Exception
 						|
 			IOException		RumtimeException			
			-File, �����		-����ð��� �߻��ϴ� ���ܵ�... NULL, ARRAY

*/
//=======================================================================
// ���� �Է� ���� ó�� Ŭ���� !!
//=======================================================================

class AgeInputException extends Exception
{
	public AgeInputException()
	{	//�θ� Ŭ������ ������ : exception
		super("���̴� ������ �� �����ϴ�.(1~255)");
	}
}

public class MainClass {

	public static void main(String[] args) {
		
		
		
		
		// getter/setter ���� �Ϲ������� ���
/*		if(age<1 || age>255)
		{
			
		}
*/
/*		���� throw�� ���ؼ� ���ܸ� �߻����� �����ϴ� ��� !!
 * 		try
		{
			int age = key.nextInt();
			System.out.println("���� : "+age);
			if(age<0)
			{
				AgeInputException e = new AgeInputException();
				throw e;	// throw : ���ܸ� �߻���Ű�� ������ ��� !!
			}
		}
		catch(AgeInputException e)
		{
			System.out.println(e.getMessage());
		}
*/		
		
		
		// ������ �޼��忡�� throw�� �߻���Ű�� �����ϴ� ��� !!
		
		try
		{
			int age = readAge();
			System.out.println("���̴� : " + age);
		}
		catch(AgeInputException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public static int readAge() throws AgeInputException
	{
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
		if(age<1)
		{
			AgeInputException e = new AgeInputException();
			throw e;
		}
		return age;
	}
}
