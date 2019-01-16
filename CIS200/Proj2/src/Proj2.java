/**
 * <Proj2.java>
* <Swapnil Gupta / Thursday 6pm - 7:50pm / Atef Khan>
*
* <Lifetime earning by degree>
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Proj2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#0.00");
		
		int userDegree = 0;
		int docWeekly = 1623;
		int masterWeekly = 1341;
		int bachWeekly = 1137;
		int highSchoolWeekly = 678;
		int noSchoolWeekly = 493;
		int docAnnual = 52 * docWeekly;
		int masterAnnual = 52 * masterWeekly; ;
		int bachAnnual = 52 * bachWeekly;
		int highSchoolAnnual = 52 * highSchoolWeekly;
		int noSchoolAnnual = 52 * noSchoolWeekly;
		boolean done = false;
		boolean done1 = false;
		String userDegreeName = null;
		int annualSalary = 0;
		int lifeSalary = 0;
		int year = 0;
		int age= 0;
		int retireAge = 0;
		
		do{
		System.out.print("1 = No Degree");
		System.out.print("\n2 = High School Degree");
		System.out.print("\n3 = Bachelor's Degree");
		System.out.print("\n4 = Masters Degree");
		System.out.print("\n5 = Doctorate Degree");
		
		do {
		System.out.print("\n \nEnter the number that corresponds to your degree: ");
		userDegree = Integer.parseInt(s.nextLine());
		
		if ((userDegree > 5) || (userDegree < 1))
		{
			System.out.print("\nYou entered an invalid menu choice. \nPlease re-run the program and enter in a valid choice.");
			done = false;
			continue;	
		}
		else{	
			done = true;
		}
		}while(done == false);
		
		System.out.print("\n \nEnter the current year: ");
		year = Integer.parseInt(s.nextLine());
		
		if ((year > 2020) || (year < 2016))
		{
			System.out.print("\nYou entered an invalid year. \nThe program will re-run.\n");
			continue;	
		}
		
		System.out.print("Enter your current age: ");
		age = Integer.parseInt(s.nextLine());
		
		if ((age > 99) || (age < 1))
		{
			System.out.print("\nYou entered an invalid age. \nThe program will re-run.\n");
			continue;	
		}
		
		System.out.print("Enter planned age of retirement: ");
		retireAge = Integer.parseInt(s.nextLine());
		
		if ((retireAge > 100) || (retireAge < 30))
		{
			System.out.print("\nYou entered an invalid age. \nThe program will re-run.\n");
			continue;	
		}
		else if (age > retireAge)
		{
			System.out.print("\nYou entered an invalid age. \nThe program will re-run.\n");
			continue;	
		}
		int retireYear = year + (retireAge - age);
		int noSchoolLife = noSchoolAnnual * (retireAge - age);
		int highSchoolLife = highSchoolAnnual * (retireAge - age);
		int bachLife = bachAnnual * (retireAge - age);
		int masterLife = masterAnnual * (retireAge - age);
		int docLife = docAnnual * (retireAge - age);
		
		if (userDegree == 1) {
			userDegreeName = "No";
			annualSalary = noSchoolAnnual;
			lifeSalary = noSchoolLife;	
			}
		else if (userDegree == 2) {
			userDegreeName = "High School";
			annualSalary = highSchoolAnnual;
			lifeSalary = highSchoolLife;
			}
		else if (userDegree == 3) {
			userDegreeName = "Bachelor's";
			annualSalary = bachAnnual;
			lifeSalary = bachLife;
			}
		else if (userDegree == 4) {
			userDegreeName = "Masters";
			annualSalary = masterAnnual;
			lifeSalary = masterLife;
			}
		else if (userDegree == 5) {
			userDegreeName = "Doctorate";
			annualSalary = docAnnual;
			lifeSalary = docLife;	
			}

		String annual = String.format("%,d", annualSalary);
		String life = String.format("%,d", lifeSalary);
		
		System.out.print("\n \nBased on current statistics and your " + userDegreeName + " degree:");
		System.out.print("\nYour annual salary will be $" + annual);
		System.out.print("\nRetiring at age " + retireAge + " in " + retireYear + " you will make a total of $" + life);
		
		int userDegreeMem = userDegree;
		String userDegreeNameMem = userDegreeName;
		String masterLess = String.format("%,d", (lifeSalary - masterLife));
		String bachLess = String.format("%,d", (lifeSalary - bachLife));
		String highSchoolLess = String.format("%,d", (lifeSalary - highSchoolLife));
		String noSchoolLess = String.format("%,d", (lifeSalary - noSchoolLife));
		do {
			
			userDegree = userDegree - 1;
			
			if (userDegree == 4)
			{
				userDegreeName = "Masters";
				annualSalary = masterAnnual;
				System.out.print("\nThat is $" + masterLess + " more than if you only had a " + userDegreeName + " degree.");
			}
			else if (userDegree == 3) {
				userDegreeName = "Bachelor's";
				annualSalary = bachAnnual;
				System.out.print("\nThat is $" + bachLess + " more than if you only had a " + userDegreeName + " degree.");
				
			}
			else if (userDegree == 2) {
				userDegreeName = "High School";
				annualSalary = highSchoolAnnual;
				System.out.print("\nThat is $" + highSchoolLess + " more than if you only had a " + userDegreeName + " degree.");
			}
			else if (userDegree == 1) {
				userDegreeName = "No";
				annualSalary = noSchoolAnnual;
				System.out.print("\nThat is $" + noSchoolLess + " more than if you only had a " + userDegreeName + " degree.");
			}
		}while (userDegree > 1);
		
		userDegree = userDegreeMem;
		String docMore = String.format("%,d", (docLife - lifeSalary));
		String masterMore = String.format("%,d", (masterLife - lifeSalary));
		String bachMore = String.format("%,d", (bachLife - lifeSalary));
		String highSchoolMore = String.format("%,d", (highSchoolLife - lifeSalary));
		do {
			
			userDegree = userDegree + 1;
			
			if (userDegree == 5) {
				userDegreeName = "Doctarate";
				annualSalary = docAnnual;
				System.out.print("\nWith a " + userDegreeName + " degree, you can earn $" + docMore + " more than if you just had a " + userDegreeNameMem + " degree.");
			}
			else if (userDegree == 4)
			{
				userDegreeName = "Masters";
				annualSalary = masterAnnual;
				System.out.print("\nWith a " + userDegreeName + " degree, you can earn $" + masterMore + " more than if you just had a " + userDegreeNameMem + " degree.");
			}
			else if (userDegree == 3) {
				userDegreeName = "Bachelor's";
				annualSalary = bachAnnual;
				System.out.print("\nWith a " + userDegreeName + " degree, you can earn $" + bachMore + " more than if you just had a " + userDegreeNameMem + " degree.");
				
			}
			else if (userDegree == 2) {
				userDegreeName = "High School";
				annualSalary = highSchoolAnnual;
				System.out.print("\nWith a " + userDegreeName + " degree, you can earn $" + highSchoolMore + " more than if you just had a " + userDegreeNameMem + " degree.");
			}
			}while( userDegree < 5);

		System.out.print("\nDo you want to enter in new information? (Y for yes, N for no)");
		char newInfo = s.nextLine().charAt(0);
		if (newInfo == 'Y')
		{
			done1 = false;
					
		}
		else if (newInfo == 'N')
		{
			done1 = true;
		}
		else
		{
			System.out.print("Invalid Entry");
			continue;
		}
		
		
	}while (done1 == false); 
	}

}
