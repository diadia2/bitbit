package chatting;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

	public static void main(String[] args) {
		try {

			ServerSocket server = new ServerSocket(10001);
			System.out.println("ä�ù��� ���µǾ����ϴ�.");

			HashMap hm = new HashMap();
			HashMap room = new HashMap();
		

			while (true) {
				Socket sock = server.accept();
				ChatThreads chatthread = new ChatThreads(sock, hm, room);
				chatthread.start();
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class ChatThreads extends Thread {
	private Socket sock;
	private String id;
	private BufferedReader br;
	private HashMap hm;
	private HashMap<String, Integer> room;
	private boolean initFlag = false;
	private String msg;
	private int roomid;

	public ChatThreads(Socket sock, HashMap hm, HashMap room) {
		this.sock = sock;
		this.hm = hm;
		this.room = room;

		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

			msg = "��ȭ���� �Է����ּ��� : ";
			pw.print(msg);
			pw.flush();
			id = br.readLine();

			msg = "ä�ù��� �����ϼ���.\r 1: �ϴû�� 2: ��ī�̷��� 3: ����ä�� 4: ������� ";
			pw.println(msg);
			pw.flush();
			roomid = Integer.parseInt(br.readLine());
			System.out.println("roomid : " + roomid);

			msg = "ä�ù濡 �����ϼ̽��ϴ�.";
			pw.println(msg);
			pw.flush();

			broadcast(id + "���� �����Ͽ����ϴ�.", roomid);

			System.out.println("������ ������� ���̵�� " + id + "�Դϴ�.");

			synchronized (hm) {
				hm.put(this.id, pw);
			}

			synchronized (room) {
				room.put(this.id, roomid);
			}

			initFlag = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void run() {

		try {
			String line = null;

			while ((line = br.readLine()) != null) {

				if (line.equals("/quit")) {
					break;
				}

				if (line.indexOf("/to") == 0) {
					sendmsg(line);
				} else {
					broadcast(id + " : " + line, roomid);
				}

			}

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(ex);
		} finally {
			synchronized (hm) {
				hm.remove(id);
			}
			broadcast(id + "���� ���� �����Ͽ����ϴ�.", roomid);

			try {
				if (sock != null)
					sock.close();
			} catch (Exception ex) {

			}

		}

	} // run

	public void sendmsg(String msg) {
		int start = msg.indexOf(" ") + 1;
		int end = msg.indexOf(" ", start);

		if (end != -1) {
			String to = msg.substring(start, end);
			String msg2 = msg.substring(end + 1);
			Object obj = hm.get(to);

			if (obj != null) {
				PrintWriter pw = (PrintWriter) obj;
				pw.println(id + " ���� ������ �ͼӸ��� �����̽��ϴ�. : " + msg2);
				pw.flush();
			} // if
		}

	}// sendmsg

	public void broadcast(String msg, int roomid) {

		synchronized (hm) {

			Set<String> s = room.keySet();
			Iterator<String> it = s.iterator();

			String id = null;
			int tmpnum = 0;

			while (it.hasNext()) {
				id = it.next();
				tmpnum = room.get(id);

				if (tmpnum == roomid) {
					PrintWriter pw = (PrintWriter) hm.get(id);
					pw.println(msg);
					pw.flush();
				}
			}

			/*
			 * Collection collection = hm.values();
			 * 
			 * 
			 * Iterator iter = collection.iterator();
			 * 
			 * while( iter.hasNext() ){ PrintWriter pw = (PrintWriter)
			 * iter.next(); pw.println(msg); pw.flush(); }
			 */
		}

	} // broadcast

}