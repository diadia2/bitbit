package DI_TEST03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("hyundai")
public class HyundaiMaker implements CarMaker{
	
	@Autowired
	private Car car;
	
	@Override
	public Car sell(Money money) {
		car.setName("�׷���");
		System.out.println(car.getName()+"�� "+money.getAmount()+"������ �Ⱦҽ��ϴ�.");
		return car;
	}
}
