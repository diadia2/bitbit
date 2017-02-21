package DI08;

import javax.annotation.Resource;

public class Car {
	
	@Resource(name="koreaTire")
	private Tire tire;
	
	//������ ���Թ��
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
