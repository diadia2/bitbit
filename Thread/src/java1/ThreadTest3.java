package java1;

class PriorityThread extends Thread{
	public PriorityThread(String name){
		super(name);
	}
	public void run(){
		for(int i=0; i<50; i++){
			System.out.println(getName()+":"+i+"��°");
		}
	}
}

public class ThreadTest3 {

	public static void main(String[] args) {

		PriorityThread p1 = new PriorityThread("���ϳ��� ������");
		PriorityThread p2 = new PriorityThread("�߰� ������");
		PriorityThread p3 = new PriorityThread("���ϳ��� ������");
		
		p1.setPriority(p1.MAX_PRIORITY);
		p2.setPriority(p2.NORM_PRIORITY);
		p3.setPriority(p3.MIN_PRIORITY);
		
		p1.start();
		p2.start();
		p3.start();
		
	}

}
