import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

class InputThread extends Thread {
	private Socket sock = null;
	private BufferedReader br = null;

	public InputThread(Socket sock, BufferedReader br) {
		this.sock = sock;
		this.br = br;
	}

	public void run() {
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
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

public class ChatClient {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("���� : java ChatClient id �����Ҽ���ip");
			System.exit(1);
		}

		Socket sock = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean endflag = false;

		try {
			sock = new Socket("localhost", 10001);
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			pw.println(args[0]);
			pw.flush();
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			InputThread it = new InputThread(sock, br);
			it.start();
			String line = null;
			while ((line = keyboard.readLine()) != null) {
				pw.println(line);
				pw.flush();
				if (line.equals("/quit")) {
					endflag = true;
					break;
				}
			}
			System.out.println("Ŭ���̾�Ʈ�� ������ ���� �մϴ�.");
		} catch (Exception e) {
			if (!endflag)
				System.out.println(e);
		} finally {
			try {
				if (pw != null)
					pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (br != null)
					br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (sock != null)
					sock.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
