interface MobilePhone
{
	public boolean sendCall();
	public boolean receiveCall();
	public boolean sendSMS();
	public boolean receriveSMS();
}
interface MP3{
	public void play();
	public void stop();
}
class PDA{
	public int calculate(int x, int y){
		return x+y;
	}
}


public class SmartPhone extends PDA implements MobilePhone, MP3{

	public boolean sendCall() {
		System.out.println("��ȭ�ɱ�");
		return true;
	}
	public boolean receiveCall() {
		System.out.println("��ȭ�ޱ�");
		return true;
	}
	public boolean sendSMS() {
		System.out.println("SMS ������");
		return true;
	}
	public boolean receriveSMS() {
		System.out.println("SMS �ޱ�");
		return true;
	}
	public void play() {
		System.out.println("���� ���");
	}
	public void stop() {
		System.out.println("��� ����");
	}
	public void schedule(){
		System.out.println("���� ����");
	}
	public void applicationManager(){
		System.out.println("�� ��ġ/����");
	}
	
	public static void main(String[] args) {

	}

}
