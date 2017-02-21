package chatting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	Socket sock = null;
	BufferedReader br = null;
	PrintWriter pw1 = null;
	boolean endflag = false;
	String id = null;
	String pw = null;

	public Client(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public void getClient() {
		try {
			sock = new Socket("localhost", 10001);
			pw1 = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

			pw1.println(this.id);
			pw1.flush();

			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			InputThread it = new InputThread(sock, br);
			it.start();
			String line = null;
			while ((line = keyboard.readLine()) != null) {
				pw1.println(line);
				pw1.flush();
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
				if (pw1 != null)
					pw1.close();
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