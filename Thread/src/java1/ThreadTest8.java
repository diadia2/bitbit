package java1;

import java.util.Random;

class ATM{
	private int balance;
	
	public ATM(int balance){
		this.balance = balance;
	}
	public void deposit(int amount, String name){
		balance += amount;
		System.out.println(name + " : �Աݱݾ� : " + amount);
	}
	public void withdraw(int amount, String name){
		if(balance-amount>0){
			balance-=amount;
			System.out.println(name + ": ��ݱݾ� : "+ amount);
		}
		else{
			System.out.println(name+"���� �ܾ��� ������ ��� �Ҽ� �����ϴ�.");
		}
	}
	public void getBalance(){
		System.out.println("���� ���� �ܾ��� : "+balance);
	}
}

class ATM_USER extends Thread{
	Random rand = new Random();
	boolean flag = true;
	ATM obj;
	
	public ATM_USER(ATM obj, String name){
		super(name);
		this.obj = obj;
	}
	public void run(){
		for(int i=0; i<5; i++){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(obj){
				if(flag){
					obj.deposit(Math.abs(rand.nextInt(10)+10), getName());
					obj.getBalance();
				}
				else{
					obj.withdraw(Math.abs(rand.nextInt(2)+1), getName());
					obj.getBalance();
				}
			}
			flag = !flag;
		}
	}
}

public class ThreadTest8 {

	public static void main(String[] args) {
		
		ATM obj = new ATM(10000);
		ATM_USER user1 = new ATM_USER(obj,"�ڳ�");
		ATM_USER user2 = new ATM_USER(obj,"���");
		ATM_USER user3 = new ATM_USER(obj,"�̶�");
		
		user1.start();
		user2.start();
		user3.start();
		
		
		
		
	}

}
