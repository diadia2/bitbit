package java1;

class Thread1 extends Thread {
	int n = 0;
	public void run(){
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("���� ������ �̸� = "+name);
		System.out.println("���� ������ ID = "+id);
		System.out.println("���� ������ �켱���� �� = "+priority);
		System.out.println("���� ������ ����= "+s);
	}
}

public class ThreadTest2 {

	public static void main(String[] args) {

		Thread1 th = new Thread1();
		
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("���� ������ �̸� = "+name);
		System.out.println("���� ������ ID = "+id);
		System.out.println("���� ������ �켱���� �� = "+priority);
		System.out.println("���� ������ ����= "+s);
		
		th.start();
		
	}

}
