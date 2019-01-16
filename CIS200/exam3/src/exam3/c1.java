package exam3;

import java.util.Scanner;

public class c1 {
	private int acctNumber;
	private String name;
	private double acctBalance;
	
	
	public c1(int n, String m, double b){
		acctNumber = n;
		name = m;
		acctBalance = b;
	}
	
	public void deposit(double amount){
		if(amount < 0){
			throw new IllegalArgumentException("Can not be below zero");
		}
		else{
			this.acctBalance = this.acctBalance + amount;
		}
	}
	
	public void withdraw(double amount){
		if(this.acctBalance - amount >= 0){
			this.acctBalance = this.acctBalance - amount;
		}
	}
	
	public String toString(){
		return acctNumber + "\n" + name + "\n" + acctBalance;
	}

}

