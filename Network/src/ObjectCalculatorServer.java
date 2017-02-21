import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ObjectCalculatorServer {

	public static void main(String[] args) {

		Socket sock = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			ServerSocket ss = new ServerSocket(10005);
			System.out.println("Ŭ���̾�Ʈ�� ������ ��� �մϴ�.");
			sock = ss.accept();

			oos = new ObjectOutputStream(sock.getOutputStream());
			ois = new ObjectInputStream(sock.getInputStream());
			Object obj = null;
			
			while ((obj = ois.readObject()) != null) {
				SendData sd = (SendData) obj;
				int op1 = sd.getOp1();
				int op2 = sd.getOp2();
				String opcode = sd.getOpcode();
				if (opcode.equals("+")) {
					oos.writeObject(op1 + " + " + op2 + " = " + (op1 + op2));
					oos.flush();
				} else if (opcode.equals("-")) {
					oos.writeObject(op1 + " - " + op2 + " = " + (op1 - op2));
					oos.flush();
				} else if (opcode.equals("*")) {
					oos.writeObject(op1 + " * " + op2 + " = " + (op1 * op2));
					oos.flush();
				} else if (opcode.equals("/")) {
					if (op2 == 0) {
						oos.writeObject("0���� ������ �����ϴ�.");
						oos.flush();
					} else {
						oos.writeObject(op1 + " / " + op2 + " = " + (op1 / op2));
						oos.flush();
					}
				}
				System.out.println("����� �����Ͽ����ϴ�.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (sock != null)
					sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
