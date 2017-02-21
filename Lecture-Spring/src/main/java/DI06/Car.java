package DI06;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	
	@Autowired
	private Tire tire;
	
	public Car(Tire tire){
		this.tire = tire;
		System.out.println("Car(Tire) ������ ȣ��...");
	}

	//setter ���Թ��
	public void setTire(Tire tire){
		this.tire = tire;
		System.out.println("setTire() �޼ҵ� ȣ��...");
	}
	
	public String getTireBrand(){
		return "������ Ÿ�̾� : " + tire.getBrand();
	}
}
