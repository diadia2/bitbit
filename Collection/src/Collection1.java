import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

//=======================================================================
// �÷��� �����ӿ�ũ !!
//	--> �ڷᱸ�� Ŭ�������� ����
//	--> C���� �ڷᱸ���� ���� �ۼ� --> ���꼺�� �������� !!
//	--> �ڷᱸ�� : �迭, ����Ʈ, ����, ť, Ʈ��, �ؽ� 
//	--> �˰��� : ����, Ž��
//=======================================================================
/*		    // --> ���ʸ�
		   	 Collection<E> 
		   	 	  |
		set<E>	List<E>	Queue<E>
*/
// map<k,v>
//=======================================================================
//	1) A~Z �̸��� �����ؼ� ��� !! --> iterator �̿� !!
//	2) 010�� ������� �ʴ� ����� ��� 010���� ��ȭ��ȣ ���� !!
//	3) outputAddr --> iterator�� �̿��Ͽ� �ٽ� ���� !!
//	4) printAddr --> list.foreach�� ���ؼ� ���� !!
//	5) �˻���� �߰�
//		--> ��ȭ��ȣ ���ڸ��� �˻� ��� �߰� !!
//	6) �׷� ��ġ��
//=======================================================================
// ArrayList�� �̿��Ͽ� 2���� �迭 ���·� �ּҷ� �ۼ� !!
//=======================================================================
//	[][][][][][][][][]	��
//	[][][][][][][][][]	��
//	[][][][][][][][][]	��
//	[][][][][][][][][]	��
//	[][][][][][][][][]	��
//	[][][][][][][][][]	��
//	�ּ��߰�, ����, �˻�(�̸�), ���
//=======================================================================

class Addr {
	String name;
	String phoneNo;

	public Addr(String name, String phoneNo) {
		this.name = name;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}

class AddressBook {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Addr> addrList;

	public AddressBook() {
		addrList = new ArrayList(10); // �⺻ 10��¥�� �迭�� �����ض� !!
	}

	public void inputAddr() // ����
	{
		System.out.println("�̸�: ");
		String name = scan.nextLine();
		System.out.println("��ȭ��ȣ: ");
		String phone = scan.nextLine();
		// 1���� �ּ� ���� !!
		Addr addr = new Addr(name, phone);
		// �߰� !!
		addrList.add(addr);

	}

	public void outputAddr() // ����
	{
		String name = scan.nextLine();
		for (int i = 0; i < addrList.size(); i++) {
			if (addrList.get(i).name.equals(name)) {
				addrList.remove(i);
				break;
			}
		}
	}

	public void printAddr() // ���
	{
		for (Addr addr : addrList) {
			System.out.println(addr.getName() + addr.getPhoneNo());
		}
	}

}
// 1) ��ȭ��ȣ ���α׷� : �ּ��߰�, ����, �˻�(�̸�), ��� (�� ��������)
// =======================================================================
// �ܼ� �޸��� ���α׷� !!
// =======================================================================
// 1) LinkedList Ŭ���� ���
// 2) space���� ������ LinkedList�� ���ڿ��� ���� !!

// I am a boy �� ����ڰ� �Է��� ���͸� ġ��

// [I] -> [am] -> [a] -> [boy]

// ��ɾ� :
// a : �߰��Է�
// z : ������ �ܾ� ����
// x : ��ü ����

public class Collection1 {

	public static void main(String[] args) {
		// java���� �⺻������ �����ϴ� �迭 Ŭ���� : ArrayList
		// ArrayList : ������ �迭�� �߻�ȭ�� Ŭ���� !!
		AddressBook book = new AddressBook();
		book.inputAddr();
		book.printAddr();
		book.inputAddr();
		book.printAddr();
		book.outputAddr();
		book.printAddr();

		List<AddressBook> list = new LinkedList<AddressBook>();
		list.add(new AddressBook());

		Iterator<AddressBook> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		/*
		 * LinkedList<Integer> list = new LinkedList<Integer>();
		 * 
		 * list.add(new Integer(10)); list.add(20); list.add(30); //����Ʈ�� ũ��
		 * for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		 * 
		 * list.remove(0);
		 * 
		 * for (Integer integer : list) { System.out.println(integer); }
		 */

	}

}
