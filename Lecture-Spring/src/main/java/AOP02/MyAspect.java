package AOP02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * 	pointCut
 * 
 *  [����������] ����Ÿ�� [��Ű��.Ŭ������] �޼ҵ��(�Ķ����) [throws ��������]
 */

@Aspect
public class MyAspect {
	
	@Before("execution(* AOP02.Boy.runSomething(..))")		// @Before("����Ʈ��")
	public static void before(JoinPoint joinPoint){			// ��������Ʈ
		System.out.println("����� ���� ���� ������ ���´�.");
	}
	
}
