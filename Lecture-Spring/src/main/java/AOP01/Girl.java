package AOP01;

public class Girl {
	
	public void runSomthing(){
		
		MyAspect.beforeRunSomething();
		
		System.out.println("�丮�� �մϴ�.");
		
		MyAspect.afterRunSomething();
	}
}
