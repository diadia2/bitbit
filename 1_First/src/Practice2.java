
class Person {
	String name;
	private String phone;

	public void setPhone(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}
}

class Professor extends Person {
	public String getPhone() {
		return "���� " + super.name + "�� ��ȭ��ȣ�� " + super.getPhone();
	}
}

public class Practice2 {

	public static void main(String[] args) {

		Professor p = new Professor();
		p.setPhone("��ö��", "010-1234-5678");
		System.out.println(p.getPhone());
	}
}
