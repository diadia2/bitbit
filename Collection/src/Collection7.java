//======================================================================
//	1) ��ȭ��ȣ�θ� �ۼ�	--> TreeMap�� �̿��ؼ�.. ���� !!
//	2) ������ ��ȭ��ȣ�� ( Addr Ŭ����)
//		--> �˻������ HashSet�� �̿��ؼ� ���� !!
//======================================================================

import java.util.*;

class AddrBook
{
	TreeMap<String, String> map;
	
	public AddrBook()
	{
		map = new TreeMap<String, String>();
	}
	
	public void input()
	{
		Scanner scan = new Scanner(System.in);
		
		String name = scan.nextLine();
		String phone = scan.nextLine();
		
		map.put(name, phone);
	}
	
	public void print()
	{
		NavigableSet<String> navi = map.navigableKeySet();
		
		Iterator<String> iter = navi.iterator();
		
		while(iter.hasNext())
		{
			System.out.println(map.get(iter.next()));
		}
	}
}

public class Collection7 {

	public static void main(String[] args) 
	{

		AddrBook ab = new AddrBook();
		ab.input();
		ab.input();
		ab.input();
		ab.print();
/*		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(3, "A3");
		map.put(2, "A2");
		map.put(4, "A4");
		map.put(1, "A1");
		map.put(5, "A5");
		// TreeMap�� Ž�� ���� Set�� ���´� !!
		NavigableSet<Integer> navi = map.navigableKeySet();
		// ��������
		Iterator<Integer> iter = navi.iterator();		// iterator�� map�� ���� �������� ������ navi�� ����
		while(iter.hasNext())
		{
			System.out.println(map.get(iter.next()));
		}
		
		Iterator<Integer> iter1 = navi.descendingIterator();
		while(iter1.hasNext())
		{
			System.out.println(map.get(iter1.next()));
		}
*/
	}

}
