package AOP01;

public class Boy {
	
	public void runSomthing(){
		
		MyAspect.beforeRunSomething();
		
		System.out.println("��ǻ�ͷ� ������ �մϴ�.");
		
		MyAspect.afterRunSomething();
	}
}
