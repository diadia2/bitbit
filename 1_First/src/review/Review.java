package review;

import java.util.Scanner;

/*�� ���� ���ڿ��� �Է¹޾Ƽ� ���� ���� �κ��� �Ǽ��� ��ȯ�� �� �ݿø��Ͽ� �Ҽ� ��°�ڸ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

ex) 22.4&34 -> 22.40
7@888@88 -> 7.00
22..1@2@ -> 22.00
3 -> 3.00

1. ������� Ǯ���� �뷫���� ����
2. �ڵ�
3. �ɸ� �ð� 
11/22 ��������*/

public class Review {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = "12.as2";
		int[] num = null;
		int sum = 0;
		
		System.out.println(str.substring(0, 0));
		
		for(int i=0; i<str.length(); i++)
		{
			num[i] = Integer.parseInt(str.substring(i, i+1));
			if(num[i]>0){
				
			}
		}
		
		
	}

}
