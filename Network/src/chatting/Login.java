package chatting;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);
      Members members = new Members();
      int choice = 0;
      
      while (true) {
         System.out.println("�����ϼ���");
         System.out.println("1.ȸ������  2.�α��� 3.����");
         choice = scan.nextInt();
         switch (choice) {
         case 1:
            System.out.print("����Ͻ� ID�� �Է��ϼ��� >> ");
            scan.nextLine();
            String id = scan.nextLine();
            System.out.print("����Ͻ� ��й�ȣ�� �Է��ϼ��� >> ");
            String pw = scan.nextLine();
            members.newMember(id,pw);
            break;
         case 2:
            System.out.print("ID�� �Է��ϼ��� >> ");
            scan.nextLine();
            id = scan.nextLine();
            System.out.print("��й�ȣ�� �Է��ϼ��� >> ");
            pw = scan.nextLine();
            members.Login(id,pw);
           break;   
         case 3:
            System.out.println("�ý����� ���� �մϴ�.");
            return;
         }
      }
      
   }

}