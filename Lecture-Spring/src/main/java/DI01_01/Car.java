package DI01_01;

public class Car {
	
	private Tire tire;
	
	public Car(){
//		this.tire = new KoreaTire();		// ���� ���� �߻�
		this.tire = new AmericaTire();
	}
	
	public String getTireBrand(){
		return "������ Ÿ�̾� : " + tire.getBrand();
	}
}
