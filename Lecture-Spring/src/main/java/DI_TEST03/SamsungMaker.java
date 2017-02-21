package DI_TEST03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungMaker implements CarMaker{
	
	@Autowired
	private Car car;
	
	@Override
	public Car sell(Money money) {
		car.setName("QM5");
		System.out.println(car.getName()+"�� "+money.getAmount()+"������ �Ⱦҽ��ϴ�.");
		return car;
	}	
}
