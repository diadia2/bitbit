import java.io.*;

public class FileCopyPaste {

	public static void main(String[] args) {
		
		// FileReader, FileWriter�� ���ڸ� �ٷ�� ������ �̹��� copy,paste���� ������...
		// Buffered�� ���پ� �о����... �ӵ��� ����
		
		InputStream in = null;  
		OutputStream fw = null;
		
		int c;
		try {
			in = new FileInputStream("C:/picture.PNG");
			fw = new FileOutputStream("src/photo.JPG");
			while((c=in.read())!=-1){
				fw.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
