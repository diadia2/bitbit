package DI08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * �������� ���� DI - @Resource , @Autowired ������̼� ��
 * 	- @Resource  : �ڹ�ǥ�� ������̼�
 *  - @Autowired : ������ ������̼�
 *  
 *  ��ü ã�� �켱����
 *  - @Resource  : type, id �� id �켱���� ���� 
 *  - @Autowired : type, id �� type �켱���� ����
 */

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di08-5.xml");
		
		Car car = context.getBean("car", Car.class);
		System.out.println(car.getTireBrand());
	}
}
