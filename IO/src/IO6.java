import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

//====================================================================
// ��üŸ���� ���Ͽ� �����ϱ� !!
//	- ���������� ��������Ÿ
//	- ���������� �ؽ�Ʈ
//	- Ŭ���� Ÿ���� ������ ���Ͽ� ���� !! (��ü Ÿ��)
//====================================================================


class Student implements Serializable
{
	int studentNo;
	String name;
	int score;
	
	public Student(int studentNo, String name, int score) 
	{
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.score = score;
	}

	public void show()
	{
		System.out.println("�й� : " + studentNo + "�̸� : " + name + "���� : " + score);
	}
}

public class IO6 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		/*
		Student s1 = new Student(1, "��ö��", 100);
		Student s2 = new Student(2, "��ö��", 100);
		Student s3 = new Student(3, "��ö��", 100);
		
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.stu"));
		
			out.writeObject(s1);
			out.writeObject(s2);
			out.writeObject(s3);
			
			out.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		*/
		
		// Object.stu ���Ͽ��� ��ü�� �о� ArrayList�� ����
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.stu"));
		
/*		Student s1 = (Student)in.readObject();
		Student s2 = (Student)in.readObject();
		Student s3 = (Student)in.readObject();
*/
		ArrayList<Student> list = new ArrayList<Student>();
		Student s;
		try
		{
			while(true)
			{
				Object o = in.readObject();
				if(o==null)
					break;
				
			list.add((Student)o);
			
			}
		}
		catch(EOFException e){
			System.out.println(e.getMessage());
		}
		finally
		{
			
		}
		// ���
		for (Student student : list)
		{
			student.show();
		}
		in.close();
		
	}

}
