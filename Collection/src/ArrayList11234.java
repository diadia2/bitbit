import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList11234 {

	public static void main(String[] args) {

		ArrayList<String> ar = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			System.out.print("�̸��� �Է��ϼ��� >> ");
			String str = scan.next();
			ar.add(str);
		}
		
		for(int i=0; i<ar.size(); i++)
			System.out.print(ar.get(i)+" ");
		
		System.out.println("");
		int longName;
		String str1 = null;
		
		for(int i=0; i<ar.size()-1; i++)
		{
			longName = ar.get(i).length();
			if(longName >= ar.get(i+1).length())
				str1 = ar.get(i);
		}
		System.out.println("���� �� �̸��� : "+str1);

		
	}

}
