import java.util.*;

// �⺻ Ÿ���� �ƴ� ��üŸ���� TreeSEt���� ��� ��� !!

//	1) Comparable �������̽��� CompareTo �޼ҵ带 ���� (��)
/*
class Addr implements Comparable<Addr>
{
	String name;
	String phoneNo;
	
	public Addr(String name, String no)
	{
		this.name = name;
		this.phoneNo = no;
	}
	public int compareTo(Addr o) {
		if(this.phoneNo.charAt(0) > o.phoneNo.charAt(0))
			return 1;
		else if(this.phoneNo.charAt(0) < o.phoneNo.charAt(0))
			return -1;
		else
			return 0;
	}
	
}
*/
public class Collection5 {

	public static void main(String[] args) 
	{
/*		TreeSet<Addr> ts = new TreeSet<Addr>();
		ts.add(new Addr("��ö��", "010"));
		ts.add(new Addr("��ö��", "011"));
		ts.add(new Addr("��ö��", "017"));
		
		Iterator<Addr> iter = ts.iterator();
		
		while(iter.hasNext())
		{
			Addr addr = iter.next();
			System.out.println(addr.name + " : " + addr.phoneNo);
		}
*/		
	}

}
