package Practice1125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Account{
	private String id;
	private String name;
	private int balance;
	
	public Account(String id, String name){
		this(id, name, 0);
	}
	public Account(String id, String name, int balance){
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	public int credit(int amount){ //�Ա�
		balance += amount;
		System.out.println(name+"�� "+amount+"�� ����,");
		return balance;
	}
	public int debit(int amount){ //���
		if(amount<=balance){
			balance -= amount;
			System.out.println(name+"�� "+amount+"�� ���,");
		}
		else
			System.out.println("Amount exceeded balance");
		return balance;
	}
	public int traceferTo(Account another, int amount){
		if(amount <= balance){
			another.balance += amount;
			balance -= amount;
			System.out.println(name+"�� "+another.name+"���� "+amount+"�� �۱�,");
		}
		else
			System.out.println("Amount exceeded balance");
		return balance;
	}
	public String toString(){
		return String.format("[id=%s, name=%s, balance=%d]",id, name, balance);
	}
}

public class pr3 {

	public static void main(String[] args) {
		
		
		Account p1 = new Account("01011111111","�ڳ�",20000);
		Account p2 = new Account("01022222222","���",100000);
		Account p3 = new Account("01033333333","�̶�",50000);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		p2.traceferTo(p1, 10000);
		p1.credit(300000);
		p3.debit(5000);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

}
