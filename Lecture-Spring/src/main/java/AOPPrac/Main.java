package AOPPrac;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("AOPPrac.xml");
		
		Human man = context.getBean("man", Human.class);
		
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.print("���� �Է� : ");
			int age = scan.nextInt();
			if(age == 0){
				System.out.println("����..");
				break;
			}
			man.setAge(age);
		}

	}

}
