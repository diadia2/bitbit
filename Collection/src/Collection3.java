import java.util.*;

//======================================================================
// set<E> �������̽��� ��ӹ޴� Ŭ������ !!
// List<E> ������ !!
//	--> set<E> ����Ÿ ���� ������ �������� �ʴ´�.. !!
//	--> ����Ÿ�� �ߺ��� ������ ������� �ʴ´�.


// HashSet<E> Ŭ����
// TreeSet<E> Ŭ����
//======================================================================



public class Collection3 {

	public static void main(String[] args) 
	{
		HashSet<String> hSet = new HashSet<String>();
		
		hSet.add("AAA");
		hSet.add("BBB");
		hSet.add("CCC");
		System.out.println(hSet.size());
		// ��ü ��� !!
		Iterator<String> iter = hSet.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		// �ؽ� �˰��� !!
		//	-> �ؽ��Լ��� ������ �Ǵ� ������ �ְ�..
		//	-> �������� ���� �з� !!
		//	-> �ſ� ���� �˻� �ӵ� !!
		String str = "AAA";
		System.out.println(str.hashCode());
		System.out.println(iter.hashCode());
		System.out.println(hSet.hashCode());
	
	}

}
