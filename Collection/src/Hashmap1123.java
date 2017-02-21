import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Student{
	int id;
	String phone;
	
	public Student(int id, String phone){
		this.id = id;
		this.phone = phone;
	}
	public String toString(){
		return id+" "+phone;
	}
}

public class Hashmap1123 {

	public static void main(String[] args) {

		HashMap<String, Integer> h = new HashMap<String, Integer>();
		
		h.put("�ѿ���", 99);
		h.put("��ȫ��", 97);
		h.put("Ȳ����", 34);
		h.put("�̿���", 98);
		h.put("������", 70);
		
		System.out.println("HashMap�� ��� ���� : "+h.size());
		Set<String> s = h.keySet();
		Iterator<String> it = s.iterator();
		
		String name = null;
		while(it.hasNext()){
			name = it.next();
			System.out.println(name + " : "+h.get(name));
		}
//		System.out.println("�ѿ��� : "+h.get("�ѿ���"));
//		System.out.println("��ȫ�� : "+h.get("��ȫ��"));
//		System.out.println("Ȳ���� : "+h.get("Ȳ����"));
//		System.out.println("�̿��� : "+h.get("�̿���"));
//		System.out.println("������ : "+h.get("������"));
//		System.out.println(h.entrySet());
		System.out.println("==================================");
		
		HashMap<String, Student> h1 = new HashMap<String, Student>();
		
		h1.put("�ѿ���", new Student(2, "010-222-2222"));
		h1.put("Ȳ����", new Student(1, "010-111-1111"));
		h1.put("�̿���", new Student(3, "010-333-3333"));
		
		System.out.println("HashMap�� ��� ���� : "+h1.size());
//		System.out.println("�ѿ��� : "+h1.get("�ѿ���"));
//		System.out.println("Ȳ���� : "+h1.get("Ȳ����"));
//		System.out.println("�̿��� : "+h1.get("�̿���"));
//		System.out.println(h1.entrySet());
		
		Set<String> s1 = h1.keySet();
		Iterator<String> it1 = h1.keySet().iterator();
		String name1 = null;
		while(it1.hasNext()){
			name1 = it1.next();
			System.out.println(name1+" : "+h1.get(name1));
		}
		
	}

}
