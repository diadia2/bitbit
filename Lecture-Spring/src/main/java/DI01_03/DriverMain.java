package DI01_03;

/*
 * ���������� DI - �Ӽ�(setter) ���Թ��
 * 	- �����ڰ� Ÿ�̾� ����
 * 	- �����ڰ� ���� �ֹ�
 * 	- �����ڰ� ���� �ڵ����� Ÿ�̾� ����
 */

public class DriverMain {

	public static void main(String[] args) {
		
		Tire tire = new KoreaTire();
		
		Car car = new Car();
		car.setTire(tire);
		
		System.out.println(car.getTireBrand());
	}
}
