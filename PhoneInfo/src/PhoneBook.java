import java.util.Calendar;
import java.util.Scanner;

interface INIT_MENU
{
	int INPUT=1, SEARCH=2, DELETE=3, EXIT=4;
}
interface INPUT_SELECT
{
	int NORMAL=1, UNIV=2, COMPANY=3;
}

class PhoneInfo
{
	String name;
	String phoneNum;
	
	public PhoneInfo(String name, String phoneNum)
	{
		this.name=name;
		this.phoneNum=phoneNum;
	}
	public void showPhoneInfo()
	{
		System.out.println("name : "+name);
		System.out.println("phone : "+phoneNum);
	}
}

class PhoneUnivInfo extends PhoneInfo
{
	String major;
	int year;
	
	public PhoneUnivInfo(String name, String phone, String major, int year)
	{
		super(name,phone);
		this.major=major;
		this.year=year;
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("major : "+major);
		System.out.println("year : "+year);
	}
}

class PhoneCompanyInfo extends PhoneInfo
{
	String company;
	
	public PhoneCompanyInfo(String name, String phone, String company)
	{
		super(name,phone);
		this.company=company;
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("company : "+company);
	}
}

class PhoneBookManager
{
	final int MAX_CNT=100;
	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	int curCnt=0;
	
	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst()
	{
		if(inst==null)
			inst = new PhoneBookManager();
		return inst;
	}
	private PhoneBookManager(){}
	private PhoneInfo readBasic()
	{
		System.out.print("�̸� : ");
		String name = MenuViewer.scan.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.scan.nextLine();
		return new PhoneInfo(name, phone);
	}
	private PhoneInfo readUniv()
	{
		System.out.print("�̸� : ");
		String name = MenuViewer.scan.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.scan.nextLine();
		System.out.print("���� : ");
		String major = MenuViewer.scan.nextLine();
		System.out.print("�г� : ");
		int year = MenuViewer.scan.nextInt();
		return new PhoneUnivInfo(name, phone, major, year);
	}
	private PhoneInfo readCompany()
	{
		System.out.print("�̸� : ");
		String name = MenuViewer.scan.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.scan.nextLine();
		System.out.print("���� : ");
		String job = MenuViewer.scan.nextLine();
		return new PhoneCompanyInfo(name, phone, job);
	}
	
	public void inputData()
	{
		System.out.println("������ �Է��� �����մϴ�..");
		System.out.println("1. �Ϲ�, 2. ����, 3. ȸ��");
		System.out.print("���� >> ");
		int choice = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();
		
		PhoneInfo pi = null;
		switch(choice)
		{
		case INPUT_SELECT.NORMAL: pi = readBasic();	break;
		case INPUT_SELECT.UNIV:	pi = readUniv();	break;
		case INPUT_SELECT.COMPANY:	pi = readCompany();	break;
		}
		infoStorage[curCnt++] = pi;
		System.out.println("������ �Է��� �Ϸ� �Ǿ����ϴ�...");
	}
	public void findData()
	{
		System.out.println("������ �˻��� �����մϴ�..");
		
		System.out.print("�̸� : ");
		String name = MenuViewer.scan.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx<0)
		{
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n");
		}
		else
		{
			infoStorage[dataIdx].showPhoneInfo();
			System.out.println("������ �˻��� �Ϸ� �Ǿ����ϴ�.");
		}
	}
	public void deleteData()
	{
		System.out.println("������ ������ �����մϴ�..");
		
		System.out.print("�̸� : ");
		String name = MenuViewer.scan.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx<0)
		{
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n");
		}
		else
		{
			for(int i=dataIdx; i<(curCnt-1); i++)
			{
				infoStorage[i]=infoStorage[i+1];
			}
			curCnt--;
			System.out.println("������ ������ �Ϸ� �Ǿ����ϴ�. \n");
		}
	}
	private int search(String name)
	{
		for(int i=0; i<curCnt; i++)
		{
			PhoneInfo curInfo = infoStorage[i];
			if(name.compareTo(curInfo.name)==0)
				return i;
		}
		return -1;
	}
}

class MenuViewer
{
	public static Scanner scan = new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ���α׷� ����");
		System.out.print("���� : ");
	}
}
public class PhoneBook {
	
	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		int choice;
		
		
		while(true)
		{
			MenuViewer.showMenu();
			choice = MenuViewer.scan.nextInt();
			MenuViewer.scan.nextLine();
			switch(choice)
			{
				case INIT_MENU.INPUT : manager.inputData();	break;
				case INIT_MENU.SEARCH : manager.findData();	break;
				case INIT_MENU.DELETE : manager.deleteData();	break;
				case INIT_MENU.EXIT : System.out.println("���α׷��� ���� �մϴ�.."); return;
				default : System.out.println("�ٽ� �Է��� �ּ���"); break;
			}
		}
				
	}

}
