import java.io.IOException;

public class RunningProcess {

	public static void main(String[] args) {
		
		try {
			Process proc = Runtime.getRuntime().exec("java FirstAWTExitEvent");
			proc.waitFor();
			
			if(proc.exitValue()==0)
				System.out.println("�� ����Ǿ���!");
			else
				System.out.println("�����ΰ� ������ �־�!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
