package dev;

import org.springframework.stereotype.Component;

@Component
public class Programmer implements Developer {

	@Override
	public void gotoOffice() {
		System.out.println("���α׷��� ���");	
	}

	@Override
	public void getoffOffice() {
		System.out.println("���α׷��� ���");	
	}

}
