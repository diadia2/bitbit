import java.io.*;
import java.net.*;

class MultiThread extends Thread {

	private Socket sock;

	public MultiThread(Socket sock) {
		this.sock = sock;
	}

	public void run() {

		try {
			InetAddress inetaddr = sock.getInetAddress();
			System.out.println(inetaddr.getHostAddress() + " �� ���� �����Ͽ����ϴ�.");

			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String line = null;

			while ((line = br.readLine()) != null) {

				System.out.println("Ŭ���̾�Ʈ�� ���� ���۹��� ���ڿ� : " + line);
				pw.println(line);
				pw.flush();
			}

			pw.close();
			br.close();
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

public class ThreadServer {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("������ ��ٸ��ϴ�.");

			while (true) {
				Socket sock = server.accept();
				MultiThread mt = new MultiThread(sock);
				mt.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
