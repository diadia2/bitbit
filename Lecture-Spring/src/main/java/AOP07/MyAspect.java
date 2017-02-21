package AOP07;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * 	pointCut
 * 
 *  [����������] ����Ÿ�� [��Ű��.Ŭ������] �޼ҵ��(�Ķ����) [throws ��������]
 */

@Aspect
public class MyAspect {

	@Pointcut("execution(* AOP07.*.runSomething())")
	void pointCut01(){
		
	}
	
	@Before("pointCut01()")
	public static void before(JoinPoint joinPoint){		
		System.out.println("����� ���� ���� ������ ���´�.");
	}
	
	@After("pointCut01()")
	public static void after(JoinPoint joinPoint){
		System.out.println("���� ���� ���� ��ϴ�.");
		System.out.println("���� ��װ� ���� �����ϴ�.");
	}
	
}
