package DI03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * �������� ���� DI - �Ӽ�(setter) ���Թ��(XML)
 * 	- �����ڴ� ���� ���͸� �̿��Ͽ� �ڵ��� ����
 * 	- ���μ��Ϳ��� Ÿ�̾� �ֹ�
 *  - ���μ��Ϳ��� �ڵ��� �ֹ�
 *  - ���μ��Ϳ��� �ڵ����� Ÿ�̾� ����
 *  - ���μ��Ͱ� �����ڿ��� Ÿ�̾ ������ �ڵ��� ����
 */

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di03.xml");
		
		Car car = (Car)context.getBean("car");
		
		System.out.println(car.getTireBrand());
	}
}
