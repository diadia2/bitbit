package DI01_02;

public class Car {
	
	private Tire tire;
	
	// ������ ����
	public Car(Tire tire){
		this.tire = tire;

	}
	
	public String getTireBrand(){
		return "������ Ÿ�̾� : " + tire.getBrand();
	}
}
