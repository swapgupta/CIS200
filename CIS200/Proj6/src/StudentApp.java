/**
 * <StudentApp.java>
 * <Swapnil Gupta / Thursday 6pm / Atef Khan>
 *
 * <This is the class that is used as the make application and prints the main program.>
*/ 
import java.text.DecimalFormat;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#0.00");
		boolean done = false;
		int count = 0;
		String [] output = new String[50];
		
		System.out.print("Enter total points possible for LABS: ");
		double posLabs = Double.parseDouble(s.nextLine());
		System.out.print("Enter total points possible for PROJECTS: ");
		double posProj = Double.parseDouble(s.nextLine());
		Student s1 = new Student(posLabs, posProj);
		
		do{
			System.out.print("\nEnter the student's name (firstname lastname): ");
			String name = (s.nextLine());
			System.out.print("Enter the student's WID: ");
			String WID = (s.nextLine());
			String[] fullName = name.split(" ");
			System.out.print("\nEnter student's total for all LABS: ");
			double sLabs = Double.parseDouble(s.nextLine());
			System.out.print("Enter student's total for all PROJECTS: ");
			double sProj = Double.parseDouble(s.nextLine());
			System.out.print("Enter student's total for CODELAB: ");
			double sCodeLab = Double.parseDouble(s.nextLine());
			System.out.print("Enter student's total for the 3 CLASS EXAMS: ");
			double sExam = Double.parseDouble(s.nextLine());
			System.out.print("Enter student's total for the FINAL EXAM: ");
			double sFinal = Double.parseDouble(s.nextLine());
			count++;
			double studentOverall = s1.findOverall(sLabs, sProj, sCodeLab, sExam, sFinal);
			output[count - 1] = s1.toString(fullName[1], fullName[0], WID, studentOverall);
			System.out.println("\n" + count + " Student(s) entered so far. \nUp to 50 students can be entered.");
			System.out.print("Would you like to enter another student? ('Y' or 'N')");
			System.out.println();
			char another = (s.nextLine()).charAt(0);
			
			if( another == 'Y' || another == 'y') { 
				continue;
			}
			else if( another == 'N' || another == 'n') { 
				break;
			}
			else System.out.print("Invalid Entry");
			
		}while(done == false || count < 50);
		
		int i = 0;
		do{
			System.out.println(output[i]);
			System.out.println("Press enter to display next student...");
			System.out.println();
			i++;
			s.nextLine();
		}while(i < count);
		System.out.print("All students displayed...");
	}

}
