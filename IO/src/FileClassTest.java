import java.io.File;

// FileŬ���� ..
// �а� ���� ������ �ƴ� ���� ���� Ŭ����

public class FileClassTest {

	public static void main(String[] args) {

		File f = new File("C:/windows");
		if(f.isFile())
			System.out.println("������");
		if(f.isDirectory())
			System.out.println("���丮��");
		String[] filenames = f.list();
		
		for(int i=0; i<filenames.length; i++)
		{
			File st = new File(f, filenames[i]);
			System.out.print(filenames[i]);
			System.out.print("����ũ�� : "+ st.length()+"\n");
		}
		
	}

}
