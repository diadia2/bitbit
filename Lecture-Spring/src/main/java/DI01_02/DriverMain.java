package DI01_02;

/*
 * ���������� DI - ������ ���Թ��
 * 	- �����ڰ� Ÿ�̾� ����
 * 	- �����ڰ� ���� �ֹ��ϸ� ������ Ÿ�̾� ����
 */

public class DriverMain {

	public static void main(String[] args) {
		
//		Tire tire = new KoreaTire();
		Tire tire = new AmericaTire();
		
		Car car = new Car(tire);
		
		System.out.println(car.getTireBrand());
	}

}
