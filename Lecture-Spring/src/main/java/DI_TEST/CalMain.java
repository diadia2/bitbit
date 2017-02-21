package DI_TEST;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *  10, 2 ��Ģ���� ����� ����ϴ� �ڵ带 ������ ����� ���Թ���� �̿��Ͽ� ����
 */
public class CalMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("di_test.xml");
		
		MyCalculator cal = (MyCalculator)context.getBean("MyCalculator");
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		
	}

}
