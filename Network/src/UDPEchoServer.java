import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {

	public static void main(String[] args) {

		if(args.length != 1){
			System.out.println("args �߸��Է�");
			System.exit(1);
		}
		
		int port = 0;
		try {
			port = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("���������� �Է�");
			System.exit(1);
		}
		
		DatagramSocket dsock = null;
		
		try {
			System.out.println("���� ��� ���� �Դϴ�.");
			dsock = new DatagramSocket(port);
			String line = null;
			while(true){
				byte[] buffer = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
				dsock.receive(receivePacket);
				String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("���۹��� ���ڿ� : "+msg);
				if(msg.equals("quit"))
					break;
				
				DatagramPacket sendPacket = new DatagramPacket(
						receivePacket.getData(),
						receivePacket.getData().length,
						receivePacket.getAddress(),
						receivePacket.getPort());
				dsock.send(sendPacket);
			}
			System.out.println("UDPEchoServer�� ���� �մϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(dsock != null)
				dsock.close();
		}
		

		
		
	}

}
