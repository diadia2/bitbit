package DI02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * �������� ���� DI - �Ӽ�(setter) ���Թ��
 * 	- ���μ��Ϳ��� Ÿ�̾� �ֹ�
 *  - ���μ��Ϳ��� �ڵ��� �ֹ�
 *  - ������ ���� �ڵ����� Ÿ�̾� ����
 */

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di02.xml");
		Tire tire = (Tire)context.getBean("tire2");
		Car car = (Car)context.getBean("car");
		
		car.setTire(tire);
		System.out.println(car.getTireBrand());
	}
}
