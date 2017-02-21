package DI07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * �������� ���� DI - @Resource ������̼��� �̿��� �ڵ�����
 * 	- �����ڴ� ���� ���͸� �̿��Ͽ� �ڵ��� ����
 * 	- ���μ��Ϳ��� Ÿ�̾� �ֹ�
 *	- ���μ��Ϳ��� ������ Ÿ�̾ ������ �ڵ��� �ֹ�
 *	- �ڵ����� �����ڿ��� ����
 */

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di07.xml");
		
		Car car = context.getBean("car", Car.class);
		System.out.println(car.getTireBrand());
	}
}
