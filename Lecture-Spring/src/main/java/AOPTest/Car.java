package AOPTest;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

	public void info(){
		System.out.println("�ڵ��� �Դϴ�.");
	}
}
