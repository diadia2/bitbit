import java.util.*;

//========================================================================
// map<E>
//	HashMap<E>
//	TreeMap<E>

//========================================================================


public class Collection6 {

	public static void main(String[] args) 
	{
		//		Ű��		�����
		HashMap<String, String> Addrs = new HashMap<String, String>(); 
		Addrs.put("��ö��", "01011112222");
		Addrs.put("��ö��", "123");
		Addrs.put("��ö��", "1234");
		// map�� iter ����� ���� ���� !! --> key���� ���ؼ� �ٷ� ���ٰ��� !!
		// Iterator<String,String> iter = Addrs.iterator --> �Ұ�
		//	1) ��ö���� ��ȭ��ȣ�� ?
		System.out.println(Addrs.get("��ö��"));
		//	2) ��ö���� ����
		System.out.println(Addrs.remove("��ö��"));
		//	��ö���� ������ Ű���̱� ������.. map�� ���� ���� �ʴ´�..
		System.out.println(Addrs.get("��ö��"));
		
	}

}
