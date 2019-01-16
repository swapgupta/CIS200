package exam3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class c2 {

	public static void main(String[] args) {
		c1 c1 = new c1(1234, "Bob Smith", 451.12);
		Scanner s = new Scanner(System.in);
		
		//System.out.print("What is the deposit amount?");
		//double amount = Double.parseDouble(s.nextLine());
		
		//c1.deposit(amount);
		
		//System.out.print(c1.toString());
		
		
		//PROBLEM 3
		ArrayList<c1> account = new ArrayList<c1>(10);
		c1[] acct = new c1[10];
		int count = 0;
		char choice = 'Y';
		do{
			
			
			System.out.println("What is the account number?");
			int number = Integer.parseInt(s.nextLine());
			
			System.out.println("What is the account name?");
			String name = (s.nextLine());
			
			System.out.println("What is the account balance?");
			double balance = Double.parseDouble(s.nextLine());
			
			acct[count] = new c1(number, name, balance);
			account.add(acct[count]);
			
			System.out.println("Do you want to add another account? (y/n)");
			choice = s.nextLine().toUpperCase().charAt(0);
			count++;
			if( choice == 'Y'){ 
				continue;
			}
			else if(choice == 'N') { 
				break;
			}
			else System.out.print("Invalid Entry");
			
			
		}while(count<10);
		
		acct[1].withdraw(100);
		
		for (int i = 0; i<acct.length; i++){
			System.out.print(acct[i].toString() + "\n");
			throw new NullPointerException();
		}
		
	}

}
