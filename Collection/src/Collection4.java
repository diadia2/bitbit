import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

//================================================================
// TreeSet<T> 
//	--> Ʈ���� �߻�ȭ�� Ŭ����
//	--> ����Ž��Ʈ�� !! --> �ڽ��� 2�� �ۿ� ���� Ʈ��(���� Ʈ��)
//================================================================



public class Collection4 {

	public static void main(String[] args) 
	{
		TreeSet<Integer> hSet = new TreeSet<Integer>();
		
		hSet.add(new Integer(3));
		hSet.add(new Integer(1));
		hSet.add(new Integer(2));
		System.out.println(hSet.size());
		// ��ü ��� !!
		Iterator<Integer> iter = hSet.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}

}
