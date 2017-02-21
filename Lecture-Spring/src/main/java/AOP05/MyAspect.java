package AOP05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * 	pointCut
 * 
 *  [����������] ����Ÿ�� [��Ű��.Ŭ������] �޼ҵ��(�Ķ����) [throws ��������]
 */

@Aspect
public class MyAspect {

	@Before("execution(* runSomething())")
	public static void before(JoinPoint joinPoint){		
		System.out.println("����� ���� ���� ������ ���´�.");
	}
	
	@After("execution(* runSomething())")
	public static void after(JoinPoint joinPoint){
		System.out.println("���� ���� ���� ��ϴ�.");
		System.out.println("���� ��װ� ���� �����ϴ�.");
	}
	
}
