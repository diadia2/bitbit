package AOP08;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * 	pointCut
 * 
 *  [����������] ����Ÿ�� [��Ű��.Ŭ������] �޼ҵ��(�Ķ����) [throws ��������]
 */

@Aspect
public class MyAspect {
	
	@Before("execution(* AOP08.Boy.runSomething())")
	public static void before(JoinPoint joinPoint){		
		System.out.println("before");
	}
	
	@After("execution(* AOP08.Boy.runSomething())")
	public static void after(JoinPoint joinPoint){
		System.out.println("after");
	}
	
	@Around("execution(* AOP08.Boy.runSomething())")
	public static void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("����� ���� ���� ������ ���´�.");
		
		joinPoint.proceed();
		
		System.out.println("���� ���� ���� ��ϴ�.");
		System.out.println("���� ��װ� ���� �����ϴ�.");
	}
	
}
