import java.io.File;

public class FileClassTest2 {

	public static void dir(File fd) {
		String[] filenames = fd.list();
		for (String s : filenames) {
			File f = new File(fd, s);
			long t = f.lastModified(); // ���������� ������ �ð�
			System.out.print(s);
			System.out.print("\t����ũ�� : " + f.length()); // ����ũ��
			System.out.printf("\t������ �ð� : %tb %td %ta %tT\n", t, t, t, t);
		}
	}

	public static void main(String[] args) {

		File f2 = new File("C:/My_Test_dir");
		File f3 = new File("src");

		String res;
		if (!f2.exists()) {
			if (!f2.mkdirs()) {
				System.out.println("���丮 ���� ����");
			}
		}

		if (f2.isFile()) {
			res = "����";
		} else {
			res = "���丮";
		}
		System.out.println(f2.getPath() + "��" + res);
		
//		dir(f3);
		f2.renameTo(new File("C:/My_Test_dir_change"));

	}

}
