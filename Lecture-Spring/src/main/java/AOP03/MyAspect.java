package AOP03;

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
	
}
