package dev;

import org.springframework.stereotype.Component;

@Component
public class Designer implements Developer{
	
	@Override
	public void gotoOffice() {
		System.out.println("�����̳� ���");
		
	}

	@Override
	public void getoffOffice() {
		System.out.println("�����̳� ���");
		
	}
	

}
