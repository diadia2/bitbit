package AOP01;

// ������ɹ����� �и�
public class MyAspect {
	
	public static void beforeRunSomething(){
		System.out.println("����� ���� ���� ������ ���´�.");
	}
	
	public static void afterRunSomething(){
		System.out.println("���� ���� ���� ��ϴ�.");
		System.out.println("���� ��װ� ���� �����ϴ�.");
	}
}
