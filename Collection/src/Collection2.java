import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

//=====================================================================
// 			Collection
//				|
//			   List
//			|		|
//	  ArrayList    LinkedList
//	  [][][][][]	
//
// ArrayList ���� !!
//	1) ���� ������ Ȯ�� Ȯ�� ���� �ϴ� ����� ���� ���.. ũ�� ���� !!
//	2) �����͸� �����ϴ� ����� ���� ��� !!
// ArrayList ���� !!
//	--> ������ ������ ���� ����ӵ��� ������ !! --> ���� !!
// LinkedList : ����/������ �ӵ��� ������. ���� ������ �� ���� �� ���.
//=====================================================================

class IntCmp implements Predicate<Integer>
{
	public boolean test(Integer t) 
	{
	// ex) ¦���� ��� �����ض� !!
		if(t<10)
			return true;
		else
			return false;
	}
}

class Cmp implements Comparator<Integer>
{
	public int compare(Integer o1, Integer o2) 
	{
		if(o1<o2)
			return -1;
		else
			return 1;
	}
}

class Replace implements UnaryOperator<Integer>
{
	public Integer apply(Integer t) 
	{
		if(t==1)
			return 1111;
		else
			return t;
	}	
}



public class Collection2 {

	public static void main(String[] args) {

		ArrayList src = new ArrayList();
		src.add(1);
		src.add(2);
		src.add(3);
		
		List<Integer> list = new LinkedList<Integer>();
		// Collection �������̽� �޼ҵ� !!
		list.add(10);		// �� �ϳ� �߰� !!
		list.addAll(src);	// �ٸ� �÷����� �־ �߰� !!
		list.add(0, 4885);
		list.addAll(0, src);
		// Iterator : �ݺ��� !!
		//	--> �÷��ǿ� �����ϴ� ���Ҹ� �����ϴ� ������ �ϴ� �������� !!
		//	--> �迭�ȿ� ��� ���Ҹ� �ѹ��� �����ؼ� ���� �������� ���� !!
		// list �ȿ��� ���ҵ��� ���� �������� ����
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext())	// ���� ���Ұ� �������� ���� ������ !!
		{
			System.out.print(iter.next()+"--");
		}
		System.out.println("--");
		
		// ���� �����.....
//		list.remove(0);						// ù��°�� ������ 
//		list.remove(new Integer(4885));		// ��ü �����
//		list.removeAll(src);				// src�� ��ü ����
//		list.removeIf(new IntCmp());		// �������� ����
//		list.clear();						// �ѹ��� ���� , removeIf���� return true�� �Է°� ����
//		list.contains(new Integer(4885));	// �ش� ���� �ִ��� ������ / true/false�� ��ȯ
//			System.out.println(list.contains(new Integer(5000)));
//		list.sort(new Cmp());				// ���� �ϱ�
//		System.out.println(list.indexOf(new Integer(4885)));	// 4885�� ���° index�� �ִ���
//		Object[] ar = list.toArray();		// Collection�� ������ java�� �⺻ �迭�� ���� !!
//		for(Object object : ar)
//		{System.out.println(object);}
		list.replaceAll(new Replace());		// ���� �÷����� ������ �ٲٱ�
		
		
		iter = list.iterator();
		while(iter.hasNext())	// ���� ���Ұ� �������� ���� ������ !!
		{
			System.out.print(iter.next()+"--");
		}
		
	}

}




