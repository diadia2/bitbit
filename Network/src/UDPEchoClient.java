import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {

	public static void main(String[] args) {

		if(args.length != 2){
			System.out.println("���� : java UDPEchoClient ip port");
			System.exit(1);
		}
		String ip = args[0];
		int port = 0;
		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.out.println("port��ȣ�� ���������� �Է�");
			System.exit(1);
		}
		
		InetAddress inetaddr = null;
		
		try {
			inetaddr = InetAddress.getByName(ip);			
		} catch (Exception e) {
			System.out.println("�߸��� �������̳� ip�Դϴ�");
			System.exit(1);
		}
		
		DatagramSocket dsock = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			dsock = new DatagramSocket();
			String line = null;
			while((line = br.readLine()) != null){
				DatagramPacket sendPacket = new DatagramPacket(
						line.getBytes(),
						line.getBytes().length,
						inetaddr,
						port);
				dsock.send(sendPacket);
				if(line.equals("quit"))
					break;
				byte[] buffer = new byte[line.getBytes().length];
				DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
				dsock.receive(receivePacket);
				String msg = new String(receivePacket.getData(), 0, receivePacket.getData().length);
				System.out.println("���� ���� ���ڿ� : "+msg);
			}
			System.out.println("UDPEchoClilent�� ���� �մϴ�.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(dsock != null)
				dsock.close();
		}
		
		
	}

}
