package AOP04;

import org.aspectj.lang.JoinPoint;

/*
 * 	pointCut
 * 
 *  [����������] ����Ÿ�� [��Ű��.Ŭ������] �޼ҵ��(�Ķ����) [throws ��������]
 */

public class MyAspect {

	public static void before(JoinPoint joinPoint){		
		System.out.println("����� ���� ���� ������ ���´�.");
	}
	
	public static void after(JoinPoint joinPoint){
		System.out.println("���� ���� ���� ��ϴ�.");
		System.out.println("���� ��װ� ���� �����ϴ�.");
	}
	
}
