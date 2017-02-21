package kr.co.bit.framwork.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface RequestMapping {	//� uri�� ������ Ư�� �޼ҵ带 ȣ���Ҽ� �ְ� �Ϸ��� ������̼�
	
	String value();		//@RequestMapping(value="") / value�� �ϳ��ۿ� ������ ��������

}
